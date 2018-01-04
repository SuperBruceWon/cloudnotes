package com.tedu.cloudnotes.util;

import java.io.Serializable;

/**
 * 结果对象
 * @author dell
 *
 */
public class NoteResult implements Serializable {
	private int status;//0表示成功,其他表示失败
	private String msg;//信息
	private Object data;//返回数据
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
