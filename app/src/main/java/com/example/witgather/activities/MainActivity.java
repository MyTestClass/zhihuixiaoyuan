package com.example.witgather.activities;

import android.content.Intent;
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
import android.widget.RadioGroup;

import com.example.witgather.R;
import com.example.witgather.fragments.Course_Fragment;
import com.example.witgather.fragments.Express_Fragment;
import com.example.witgather.fragments.ObjectFragment;
import com.example.witgather.fragments.Study_Fragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,RadioGroup.OnCheckedChangeListener {
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

        RadioGroup group = (RadioGroup)findViewById(R.id.main_radio_button);
        group.setOnCheckedChangeListener(this);

        //首页显示课表
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        courseFragment = new Course_Fragment();
        currentFragment = courseFragment;
        transaction.add(R.id.fragment,courseFragment);
        transaction.show(courseFragment);
        transaction.commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(checkedId == R.id.course){
            if(courseFragment==null) {
                courseFragment = new Course_Fragment();
                transaction.add(R.id.fragment,courseFragment);
            }
            transaction.hide(currentFragment);
            currentFragment = courseFragment;
            transaction.show(courseFragment);
        }else if(checkedId==R.id.object){
            if (objectFragment==null){
                objectFragment = new ObjectFragment();
                transaction.add(R.id.fragment,objectFragment);
            }
            transaction.hide(currentFragment);
            currentFragment = objectFragment;
            transaction.show(objectFragment);
        }else if(checkedId == R.id.express){
            if (expressFragment==null){
                expressFragment = new Express_Fragment();
                transaction.add(R.id.fragment,expressFragment);
            }
            transaction.hide(currentFragment);
            currentFragment = expressFragment;
            transaction.show(expressFragment);
        }else if(checkedId == R.id.study){
            if(studyFragment==null){
                studyFragment = new Study_Fragment();
                transaction.add(R.id.fragment,studyFragment);
            }
            transaction.hide(currentFragment);
            currentFragment = studyFragment;
            transaction.show(currentFragment);
        }
        transaction.commit();
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

    private Intent intent = new Intent();
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_qiehuanzhanghao){
            intent.setClass(this,Login_Activity.class);
        }else if(id == R.id.nav_register){
            intent.setClass(this,Register_Activity.class);
        }else if(id == R.id.nav_banbensheji){

        }else if(id == R.id.nav_naozhongshezhi){

        }else if(id == R.id.nav_wodeshezhi){

        }else if(id == R.id.nav_tuichudenglu){
            Runtime.getRuntime().exit(1);
        }else if(id == R.id.nav_xiugaiwodexinxi){

        }else if(id== R.id.nav_qingchuhuancun){

        }else if(id == R.id.nav_yonghufankui){

        }
        startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
