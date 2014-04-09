package com.brahmand.restloader.lib.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADARSH on 08-04-2014.
 */
public class RequestEntity<T> {
    private T                   mData;
    private Header              mHeader;
    private String              mUrl;
    private Object[]            mUrlDataArray;
    private Map<String, Object> mUrlDataMap;


    /**
     * This method used to put key-value pair of url data.
     * @param dataMap
     * @return
     */
    public RequestEntity<T> addUrlDataMap(Map<String, Object> dataMap) {
        mUrlDataMap = dataMap;

        return this;
    }

    /**
     *
     * @param objects
     * @return
     */
    public RequestEntity addUrlDataArray(Object... objects) {
        mUrlDataArray = objects;

        return this;
    }

    public RequestEntity<T> addUrl(String url) {
        mUrl = url;

        return this;
    }

    public RequestEntity<T> addEntity(T data) {
        mData = data;
        return this;
    }

    public RequestEntity<T> addHeader(Header header) {
        mHeader = header;
        return this;
    }

    public String getUrl() {
        return mUrl;
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
