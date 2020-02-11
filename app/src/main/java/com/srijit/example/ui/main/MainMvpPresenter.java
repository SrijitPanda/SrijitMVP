  package com.srijit.example.ui.main;

import com.srijit.example.ui.base.MvpPresenter;



public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void getData();

}
