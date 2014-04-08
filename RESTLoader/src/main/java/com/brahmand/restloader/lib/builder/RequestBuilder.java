package com.brahmand.restloader.lib.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADARSH on 08-04-2014.
 */
public class RequestBuilder<T> {
    private T       mData;
    private Header  mHeader;
    private String  mUrl;


    public RequestBuilder<T> addUrl(String url) {
        mUrl = url;

        return this;
    }

    public RequestBuilder<T> addEntity(T data) {
        mData = data;
        return this;
    }

    public RequestBuilder<T> addHeader(Header header) {
        mHeader = header;
        return this;
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
