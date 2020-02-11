  package com.srijit.example.ui.main;

import com.srijit.example.ui.base.MvpView;



public interface MainMvpView extends MvpView {

    void showData(String data);

    void showError(String error);
}
