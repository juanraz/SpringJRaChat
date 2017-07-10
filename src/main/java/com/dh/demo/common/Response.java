package com.dh.demo.common;

/**
 * Created by Juan Zapata on 7/9/2017.
 */
public interface Response<T> {
    public String getMessage();

    public void setMessage(String message);

    public Boolean getSuccess();

    public void setSuccess(Boolean success);

    public T getResponseObject();

    public void setResponseObject(T responseObject);
}
