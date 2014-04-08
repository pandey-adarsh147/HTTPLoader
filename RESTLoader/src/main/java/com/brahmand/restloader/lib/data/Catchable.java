package com.brahmand.restloader.lib.data;

/**
 * Created by ADARSH on 29/3/14.
 */
public interface Catchable<V, T extends Throwable> {
    V getValue() throws T;
}
