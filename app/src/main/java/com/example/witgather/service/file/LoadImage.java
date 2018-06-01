package com.example.witgather.service.file;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.witgather.utils.Binary2String;
import com.example.witgather.utils.JSONClient;
import com.example.witgather.utils.MessageHeader;
import com.example.witgather.utils.MessageType;
import com.example.witgather.utils.RequestHandler;
import com.example.witgather.utils.ServiceConfig;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 负责加载图片并显示到指定的 ImageView 上
 */
public class LoadImage extends AsyncTask<String, Void, Bitmap> {
//    连接后，返回一个处理对象，通过该方法就可以发送请求并获取数据了
    static final RequestHandler handler = JSONClient.connect(ServiceConfig.Service_Port, ServiceConfig.Service_Address);
    private ImageView imageView;

    public LoadImage(ImageView imageView) {
        this.imageView = imageView;
    }
    /**
     * @param strings 第一个参数就是用户的ID，第二个参数就是图片的URL
     * @return
     */
    @Override
    protected Bitmap doInBackground(String... strings) {
        JSONObject json = new JSONObject();
        try {
            json.put(MessageHeader.USER_ID, strings[0]);
            json.put(MessageHeader.TYPE, MessageType.FILE);
            json.put(FileConstant.SUBOPERATION, FileConstant.LOADFILE);
            json.put(FileConstant.FILEURL, strings[1]);
            byte[] image = Binary2String.decoder(handler.requestForResult(json).getString(FileConstant.FILESTREAM));
            return BitmapFactory.decodeByteArray(image, 0, image.length);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        this.imageView.setImageBitmap(bitmap);
    }
}
