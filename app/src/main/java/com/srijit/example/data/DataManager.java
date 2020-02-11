  package com.srijit.example.data;

import com.srijit.example.data.listeners.DataListener;
import com.srijit.example.data.local.PreferencesHelper;
import com.srijit.example.data.remote.ApiHelper;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DataManager {

    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public DataManager(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        this.mPreferencesHelper = preferencesHelper;
        this.mApiHelper = apiHelper;
    }

    public void getData(final DataListener listener) {

        final String data = mPreferencesHelper.getData();

        if (data != null) {
            listener.onResponse(data);
            return;
        }

        mApiHelper.getData(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                mPreferencesHelper.putData(response);
                listener.onResponse(response);
            }

            @Override
            public void onError(ANError anError) {
                listener.onError(anError.getErrorDetail());
            }
        });

    }
}
