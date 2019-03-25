package com.example.ebor.exception;

/**
* @ClassName: BusinessException
* @Description: 
* @author jianggk3
* @date 2018年9月7日
*
*/
public class BusinessException extends RuntimeException {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException() {
        super();
        this.code = 0;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    
}
