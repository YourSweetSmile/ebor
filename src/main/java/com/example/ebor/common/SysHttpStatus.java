package com.example.ebor.common;

/**
 * 定义系统处理的返回格式
 * @author yinjw
 */
public enum SysHttpStatus {

    /**
     * 系统处理成功时返回
     */
    SUCCESS(true, "success"),

    /**
     * 系统处理异常时返回
     */
    ERROR(false, "error");

    private final boolean success;
    private final String msg;

    SysHttpStatus(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }
}
