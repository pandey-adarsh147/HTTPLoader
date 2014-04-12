package com.brahmand.restloader.lib.builder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADARSH on 08-04-2014.
 */
public class RequestEntity<T> {
    private T data;
    private HttpHeaders httpHeaders;
    private String url;
    private Object[] urlDataArray;
    private Map<String, Object> urlDataMap;
    private HttpMethod httpMethod;


    /**
     * This method used to put key-value pair of url data.
     * @param dataMap
     * @return
     */
    public RequestEntity<T> addUrlDataMap(Map<String, Object> dataMap) {
        this.urlDataMap = dataMap;

        return this;
    }

    /**
     *
     * @param objects
     * @return
     */
    public RequestEntity addUrlDataArray(Object... objects) {
        this.urlDataArray = objects;

        return this;
    }

    public RequestEntity<T> addUrl(String url) {
        this.url = url;

        return this;
    }

    public RequestEntity<T> addEntity(T data) {
        this.data = data;
        return this;
    }

    public RequestEntity<T> addHttpHeaders(HttpHeaders header) {
        this.httpHeaders = header;
        return this;
    }

    public RequestEntity<T> addData(T data) {
        this.data = data;

        return this;
    }

    public RequestEntity<T> addHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;

        return this;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public T getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public Object[] getUrlDataArray() {
        return urlDataArray;
    }



    public Map<String, Object> getUrlDataMap() {
        return urlDataMap;
    }

    public static class Header {
        private Map<String, String> mHeader = new HashMap<String, String>();

        public void add(String key, String value) {
            mHeader.put(key, value);
        }

        public String get(String key) {
            return mHeader.get(key);
        }

        public Map<String, String> getHeader() {
            return mHeader;
        }
    }
}
