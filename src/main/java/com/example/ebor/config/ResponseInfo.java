package com.example.ebor.config;

/**
 * 返回参数统一化
 * @author yinjunwu
 * @param <T>
 */
public class ResponseInfo<T> {

	private boolean success;
	private long timestamp=System.currentTimeMillis();
	private T data;
	private String msg;

	public ResponseInfo(boolean success,String msg){
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

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
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
