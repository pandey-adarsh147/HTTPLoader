package com.brahmand.restloader.lib;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import com.brahmand.restloader.lib.data.Catchable;

/**
 * Created by ADARSH on 29/3/14.
 */
public abstract class HTTPLoaderCallback<D, T extends Throwable> implements LoaderManager.LoaderCallbacks<Catchable<D, T>> {
    private static final String TAG = HTTPLoaderCallback.class.getName();

    @SuppressWarnings("unchecked")
    @Override
    public void onLoadFinished(Loader<Catchable<D, T>> catchableLoader, Catchable<D, T> dtCatchable) {
        try {
            this.onSuccess(catchableLoader, dtCatchable.getValue());
        } catch (Throwable t) {
            Log.e(TAG, "Error while finishing callbacks id: " + catchableLoader.getId() + " Cause: " + t.getCause() + " Message:" + t.getMessage(), t);
            this.onFailure(catchableLoader, (T)t);
        }
    }

    @Override
    public void onLoaderReset(Loader<Catchable<D, T>> catchableLoader) {

    }

    protected void onSuccess(Loader<Catchable<D, T>> loader, D value) {
    }

    protected void onFailure(Loader<Catchable<D, T>> loader, T throwable) {

    }
}
