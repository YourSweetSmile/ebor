package com.example.ebor.config;

import com.example.ebor.common.SysHttpStatus;

import java.util.Date;

/**
 * 返回参数统一化
 * @author yinjunwu
 * @param <T>
 */
public class ResponseInfo<T> {

	private boolean success;
	private Date timestamp=new Date();
	private T data;
	private String msg;

	public ResponseInfo(T data) {
		this.success = SysHttpStatus.SUCCESS.isSuccess();
		this.msg = SysHttpStatus.SUCCESS.getMsg();
		this.data = data;
	}

	public ResponseInfo(boolean success, String msg){
		this.success=success;
		this.msg=msg;
	}

	public ResponseInfo(boolean success, T data, String msg) {
        this.data = data;
        this.success = success;
        this.msg = msg;
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
