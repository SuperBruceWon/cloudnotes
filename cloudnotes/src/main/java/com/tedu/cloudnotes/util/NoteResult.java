package com.tedu.cloudnotes.util;

import java.io.Serializable;

/**
 * �������
 * @author dell
 *
 */
public class NoteResult implements Serializable {
	private int status;//0��ʾ�ɹ�,������ʾʧ��
	private String msg;//��Ϣ
	private Object data;//��������
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
