package com.brahmand.restloader.lib.data;

/**
 * Created by ADARSH on 29/3/14.
 */
public class CatchableException<V, T extends Throwable> implements Catchable<V, T> {

    private T throwable;

    public CatchableException(T t) {
        this.throwable = t;

    }

    @Override
    public V getValue() throws T {
        throw this.throwable;
    }
}
