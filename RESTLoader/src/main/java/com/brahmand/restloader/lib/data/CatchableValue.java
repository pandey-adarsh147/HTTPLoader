package com.brahmand.restloader.lib.data;

/**
 * Created by ADARSH on 29/3/14.
 */
public class CatchableValue<V, T extends Throwable> implements Catchable<V, T> {

    private V value;

    public CatchableValue(V v) {
        this.value = v;

    }

    @Override
    public V getValue() throws T {
        return null;
    }
}
