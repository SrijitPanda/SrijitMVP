  package com.srijit.example.injection.component;

import android.app.Application;
import android.content.Context;

import com.srijit.example.MyApplication;
import com.srijit.example.data.DataManager;
import com.srijit.example.injection.annotation.ApplicationContext;
import com.srijit.example.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

    @ApplicationContext
    Context context();

    Application application();
    DataManager dataManager();

}
