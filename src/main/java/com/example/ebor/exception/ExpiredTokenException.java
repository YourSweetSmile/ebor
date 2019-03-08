package com.example.ebor.exception;

import org.springframework.security.core.AuthenticationException;


@SuppressWarnings("serial")
public class ExpiredTokenException extends AuthenticationException {
    
    private String token;

    public ExpiredTokenException(String msg) {
        super(msg);
    }

    public ExpiredTokenException(String token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return token;
    }
}
