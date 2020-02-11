package com.srijit.example.injection.component;

import com.srijit.example.injection.annotation.PerActivity;
import com.srijit.example.injection.module.ActivityModule;
import com.srijit.example.ui.main.MainActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
