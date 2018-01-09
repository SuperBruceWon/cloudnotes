package com.tedu.cloudnotes.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	/**
	 * �������src���ܴ���
	 * @param src �����ַ���
	 * @return ���ܺ���ַ������
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String src) throws NoSuchAlgorithmException{
		//���ַ�����Ϣ����MD5����
		MessageDigest md = 
				MessageDigest.getInstance("MD5");
		byte[] output = md.digest(src.getBytes());
		//��MD5������ת��Ϊbase64
		String s = Base64.encodeBase64String(output);
		return s;
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(md5("961125"));
		System.out.println(md5("1235436456dsfsvgsafd"));
	}

}
