package com.srijit.example.data.remote;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interfaces.StringRequestListener;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ApiHelper {

    @Inject
    public ApiHelper() {

    }

    public void getData(StringRequestListener listener) {
        AndroidNetworking.get(ApiEndPoint.GET_DATA)
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "3")
                .build()
                .getAsString(listener);
    }
}
