package com.brahmand.restloader.lib;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.brahmand.restloader.lib.data.Catchable;
import com.brahmand.restloader.lib.data.CatchableException;
import com.brahmand.restloader.lib.data.CatchableValue;

/**
 * Created by ADARSH on 29/3/14.
 */
public abstract class HTTPAsyncLoader<D, T extends Throwable> extends AsyncTaskLoader<Catchable<D, T>> {

    private static final String TAG = HTTPAsyncLoader.class.getName();

    private static final long STALE_DELTA = 60000;
    private long mLastLoad;
    private Catchable<D, T> mData;


    public HTTPAsyncLoader(Context context) {
        super(context);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Catchable<D,T> loadInBackground() {
        try {

            return new CatchableValue<D, T>(this.load());
        } catch (Throwable e) {
            return new CatchableException<D, T>((T) e);
        }
    }

    @Override
    public void deliverResult(Catchable<D, T> data) {
        if (isReset()) {
            if (BuildConfig.DEBUG) Log.w(TAG, "+++ Warning! An async query came in while the Loader was reset! +++");
            return;
        }

        mData = data;

        if (isStarted()) {
            if (BuildConfig.DEBUG) Log.i(TAG, "+++ Delivering results to the LoaderManager for" +
                    " the ListFragment to display! +++");
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStartLoading() {
        if (BuildConfig.DEBUG) Log.i(TAG, "+++ onStartLoading() called! +++ : " + getId());

        if (mData != null) {
            if (BuildConfig.DEBUG) Log.i(TAG, "+++ Delivering previously loaded data to the client... : " + getId());
            deliverResult(mData);
        }

        if (mData == null || System.currentTimeMillis() - mLastLoad >= STALE_DELTA) {
            if (BuildConfig.DEBUG) Log.i(TAG, "+++ The current data is data is null... or timed out so force load! +++ : " + getId());
            forceLoad();
        }
        mLastLoad = System.currentTimeMillis();
    }



    @Override
    protected void onStopLoading() {
        if (BuildConfig.DEBUG) Log.i(TAG, "+++ onStopLoading() called! +++ : " + getId());

        cancelLoad();
    }

    protected abstract D load() throws T;
}
