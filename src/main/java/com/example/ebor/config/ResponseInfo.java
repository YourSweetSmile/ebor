package com.example.ebor.config;

public class ResponseInfo<T> {

	private boolean success;
	private long timestamp;
	private T message;
	private String url;
	
	public ResponseInfo(boolean success, T message, String url) {
        this.message = message;
        this.success = success;
        this.url = url;
        this.timestamp = System.currentTimeMillis();
    }

	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
