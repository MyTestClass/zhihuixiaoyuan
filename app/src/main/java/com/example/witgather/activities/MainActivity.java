package com.example.witgather.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.witgather.R;
import com.example.witgather.fragments.Course_Fragment;
import com.example.witgather.fragments.ObjectFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    用于临时保存Fragment的
   private Fragment currentFragment;
    private Fragment courseFragment;
    private Fragment objectFragment;
    private Fragment studyFragment;
    private Fragment expressFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ButtonMenuListener bl = new ButtonMenuListener();
        Button button_course = (Button) findViewById(R.id.course);
        button_course.setOnClickListener(bl);

        Button button_object = (Button) findViewById(R.id.object);
        button_object.setOnClickListener(bl);

        Button button_express = (Button) findViewById(R.id.express);
        button_express.setOnClickListener(bl);

        Button button_study = (Button) findViewById(R.id.study);
        button_study.setOnClickListener(bl);

        //首页显示课表
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        courseFragment = new Course_Fragment();
        currentFragment = courseFragment;
        transaction.add(R.id.fragment,courseFragment);
        transaction.show(courseFragment);
        transaction.commit();

    }
//    底部按钮的监听
    class ButtonMenuListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (v.getId()){
                case R.id.course:
                    if(courseFragment==null) {
                        courseFragment = new Course_Fragment();
                       transaction.add(R.id.fragment,courseFragment);
                    }
                    transaction.hide(currentFragment);
                    currentFragment = courseFragment;
                    transaction.show(courseFragment);
                    break;
                case R.id.object:
                    if (objectFragment==null){
                        objectFragment = new ObjectFragment();
                        transaction.add(R.id.fragment,objectFragment);
                    }
                    transaction.hide(currentFragment);
                    currentFragment = objectFragment;
                    transaction.show(objectFragment);
                    break;
                case R.id.express:
                    break;
                case R.id.study:
                    break;
            }
            transaction.commit();
        }
    }

//返回按钮的监听，这里点击的时候就关闭抽屉
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//右上角的菜单栏
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//右上角菜单栏的监听事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
