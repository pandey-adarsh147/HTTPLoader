package com.brahmand.restloader.lib;

import android.content.Context;
import android.util.Log;
import com.brahmand.restloader.lib.builder.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ADARSH on 09-04-2014.
 */
public class RESTAsyncLoader<D, R> extends HTTPAsyncLoader<ResponseEntity<D>, Throwable> {
    private static final String TAG = RESTAsyncLoader.class.getName();

    private Class<D>            mResponseType;
    private RequestEntity<R>    mRequestEntity;

    public RESTAsyncLoader(Context context, Class<D> responseType, RequestEntity<R> requestEntity) {
        super(context);

        if (responseType == null) {
            if (BuildConfig.DEBUG) Log.d(TAG, "responseType should not be null.");

            throw new IllegalArgumentException("responseType should not be null.");
        }

        if (requestEntity == null) {
            if (BuildConfig.DEBUG) Log.d(TAG, "requestEntity should not be null.");

            throw new IllegalArgumentException("requestEntity should not be null.");
        }

        mResponseType = responseType;
        mRequestEntity = requestEntity;
    }

    @Override
    protected ResponseEntity<D> load() throws Throwable {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        ResponseEntity<D> dResponseEntity = restTemplate.getForEntity(mRequestEntity.getUrl(), mResponseType, "heloo");
        return dResponseEntity;
    }

}
