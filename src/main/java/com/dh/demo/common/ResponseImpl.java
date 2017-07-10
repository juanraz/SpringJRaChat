package com.dh.demo.common;


import org.springframework.stereotype.Component;

/**
 * Created by Juan Zapata on 7/9/2017.
 */
@Component
public class ResponseImpl<T> implements Response {
    private String message;
    private Boolean success;
    private T responseObject;

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public Object getResponseObject() {
        return responseObject;
    }

    @Override
    public void setResponseObject(Object responseObject) {
        this.responseObject = (T)responseObject;
    }
}
