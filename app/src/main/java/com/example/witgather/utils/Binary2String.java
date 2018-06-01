package com.example.witgather.utils;
import net.iharder.Base64;
import java.io.IOException;
/**
 * @author 陈康勇
 *	用于将二进制的数据进行编码，然后便于使用JSON进行传输
 */
public class Binary2String {
	/**
	 * 经过Base64编码的字符串转换为二进制流
	 */
	public static byte[] decoder(String msg) {
		try {
			return Base64.decode(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将二进制流转换为字符串，然后使用JSON传输
	 *
	 */
	public static String encoder(byte[] buffer) {
		return Base64.encodeBytes(buffer);
	}
}
