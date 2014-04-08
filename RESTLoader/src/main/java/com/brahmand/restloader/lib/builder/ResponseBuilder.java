package com.brahmand.restloader.lib.builder;

/**
 * Created by ADARSH on 08-04-2014.
 */
public class ResponseBuilder<T> {

    private T mData;

    private Class<T> mResponseType;


    public ResponseBuilder<T> addResponseType(Class<T> aClass) {
        mResponseType = aClass;

        return this;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public Class<T> getResponseType() {
        return mResponseType;
    }
}
