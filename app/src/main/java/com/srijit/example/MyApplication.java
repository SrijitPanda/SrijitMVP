  package com.srijit.example;

import android.app.Application;
import android.content.Context;

import com.srijit.example.injection.component.ApplicationComponent;
import com.srijit.example.injection.component.DaggerApplicationComponent;
import com.srijit.example.injection.module.ApplicationModule;
import com.androidnetworking.AndroidNetworking;



public class MyApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
