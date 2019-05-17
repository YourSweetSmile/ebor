package com.example.ebor.exception;

import java.util.Map;

import com.example.ebor.common.SysHttpStatus;
import com.example.ebor.config.ResponseInfo;
import com.fasterxml.jackson.core.JsonParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 对返回参数的统一处理
 *
 * @author yinjw
 */
@RestControllerAdvice
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {

    Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 格式化返回参数
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(!(body instanceof ResponseInfo)){

            Object code = ((Map) body).get("status");
            if(null != code && ((Integer)code) == HttpStatus.NOT_FOUND.value()){

                return new ResponseInfo(SysHttpStatus.ERROR.isSuccess(), "URL Not Found");
            }
            return new ResponseInfo(SysHttpStatus.SUCCESS.isSuccess(), body, SysHttpStatus.SUCCESS.getMsg());
        }else{
            return body;
        }
    }

    /**
     * 异常的统一处理
     * @param isTrue
     * @param msg
     * @param realMsg
     * @return
     */
    private ResponseInfo<String> getResult(boolean isTrue, String msg, String realMsg) {
        ResponseInfo res = new ResponseInfo(isTrue, msg);
        logger.error("发生异常:{},响应的异常信息:{}" ,msg, realMsg);
        return res;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseInfo getNullPointerException(NullPointerException e) {

        return getResult(SysHttpStatus.ERROR.isSuccess(), "空指针异常", e.getMessage());
    }
    
    @ExceptionHandler(MultipartException.class)
    public ResponseInfo getMultipartException(MultipartException e, RedirectAttributes redirectAttributes) {
        return getResult(SysHttpStatus.ERROR.isSuccess(), e.getMessage(), e.getMessage());
    }

    @ExceptionHandler(SysRuntimeExeption.class)
    public ResponseInfo getSysException(SysRuntimeExeption e, RedirectAttributes redirectAttributes) {
        return getResult(SysHttpStatus.ERROR.isSuccess(), e.getMessage(), e.getMessage());
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseInfo getJsonParseException(JsonParseException e, RedirectAttributes redirectAttributes) {
        return getResult(SysHttpStatus.ERROR.isSuccess(), e.getMessage(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseInfo getAllError(Exception e) {

        return getResult(SysHttpStatus.ERROR.isSuccess(), "未知的异常发生了", e.getMessage());
    }

}
