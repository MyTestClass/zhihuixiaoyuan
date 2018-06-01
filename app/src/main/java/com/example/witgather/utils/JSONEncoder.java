package com.example.witgather.utils;

import org.json.JSONObject;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class JSONEncoder extends MessageToMessageEncoder<JSONObject> {
	@Override
	protected void encode(ChannelHandlerContext ctx, JSONObject msg, List<Object> out) throws Exception {
		out.add(msg.toString());
		
	}
}