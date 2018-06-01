package com.example.witgather.utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class JSONClient {
    private static ChannelFuture f;
    private static EventLoopGroup group;
    public static RequestHandler connect(int port, String host) {
        group = new NioEventLoopGroup();
        final RequestHandler handler = new RequestHandler();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel arg0) throws Exception {
                        arg0.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024 * 1024, 0, 2, 0, 2))
                                .addLast(new LengthFieldPrepender(2))
                                .addLast(new StringDecoder())
                                .addLast(new StringEncoder())
                                .addLast(new JSONEncoder())
                                .addLast(new JSONDecoder())
                                .addLast(handler);
                    }
                });

        f = b.connect(host, port);
        return handler;
    }

    public static void shutdown() {
        try {
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}

