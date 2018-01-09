package com.tedu.cloudnotes.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	/**
	 * 将传入的src加密处理
	 * @param src 明文字符串
	 * @return 加密后的字符串结果
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String src) throws NoSuchAlgorithmException{
		//将字符串信息采用MD5处理
		MessageDigest md = 
				MessageDigest.getInstance("MD5");
		byte[] output = md.digest(src.getBytes());
		//将MD5处理结果转化为base64
		String s = Base64.encodeBase64String(output);
		return s;
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(md5("961125"));
		System.out.println(md5("1235436456dsfsvgsafd"));
	}

}
