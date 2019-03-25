package com.example.ebor.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.example.ebor.config.ResponseInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestControllerAdvice
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {

    Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(!(body instanceof ResponseInfo)){
            return new ResponseInfo(true, body, "请求成功");
        }else{
            return body;
        }
    }

    private ResponseInfo<String> getResult(boolean isTrue, String msg, String realMsg) {
        ResponseInfo res = new ResponseInfo(isTrue, msg);
        logger.error("发生异常:{},响应的异常信息:{}" ,msg, realMsg);
        return res;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseInfo requestNotReadable(NullPointerException e) {

        return getResult(false, "空指针异常", e.getMessage());
    }
    
    @ExceptionHandler(MultipartException.class)
    public ResponseInfo handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        return getResult(false, e.getMessage(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseInfo requestNotReadable(Exception e) {

        return getResult(false, "未知的异常发生了", e.getMessage());
    }

}
