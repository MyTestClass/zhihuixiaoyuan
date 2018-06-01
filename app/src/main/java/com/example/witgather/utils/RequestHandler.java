package com.example.witgather.utils;

import org.json.JSONObject;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class RequestHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(RequestHandler.class.getName());
    private JSONObject result ;
    private ChannelHandlerContext ctx;
    private Semaphore semaphore = new Semaphore(0);
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;
//		等待初始化通道完成
        semaphore.release();
    }

    /**
     * @param request 请求的参数
     * @return	服务器端返回的结果
     * 			异常返回null
     */
    public JSONObject requestForResult(JSONObject request){
        try {
//			还没有初始化完成
            if(this.ctx==null)
                semaphore.acquire();
            ctx.writeAndFlush(request);
//			等待结果获取成功
            semaphore.acquire();
            return this.result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        result = (JSONObject) msg;
        semaphore.release();
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\陈康勇\\Desktop\\" + i + ".jpg");
//		fos.write(Binary2String.decoder(json.getString(File.FILESTREAM)));
//		fos.flush();
//		fos.close();
//		if (i < 10) {
//			JSONObject json1 = new JSONObject();
//			json1.put("userId", "13202355181");
//			json1.put("type", "file");
//			json1.put("url", "C:\\Users\\陈康勇\\Desktop\\01.jpg");
//			ctx.writeAndFlush(json1);
//		} else {
//			ctx.close();
//		}
    }

    /**
     * 完成一次批量传输后，可以关闭该连接
     */
    public void closeConnection() {
        this.ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        logger.warning(cause.getMessage());
        ctx.close();
    }
}
