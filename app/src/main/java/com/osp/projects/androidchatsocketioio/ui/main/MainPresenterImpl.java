package com.osp.projects.androidchatsocketioio.ui.main;

import android.util.Log;

import com.osp.projects.androidchatsocketioio.ui.login.LoginActivity;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 *
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnGetFriendsFinished{


    private MainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView){
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void initialRestaurantData() {

    }

    @Override
    public void initialMenuOptionData() {

    }

    @Override
    public void configMenuOptionAdapter(LoginActivity mainActivity) {

    }

    @Override
    public void configRestaurantAdapter(LoginActivity mainActivity) {

    }

    @Override
    public void serviceFriends(int userId) {
        mainInteractor.serviceGetFriendsByUserId(userId, this);
    }

    @Override
    public void onSuccessful() {

        Log.e("SUCCESS","SUCCESS");


    }

    @Override
    public void onError() {

        Log.e("ERROR","ERROR");

    }

    @Override
    public void onFailure() {

        Log.e("FAILURE","FAILURE");

    }
}
