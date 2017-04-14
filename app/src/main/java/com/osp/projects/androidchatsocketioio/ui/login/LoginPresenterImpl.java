package com.osp.projects.androidchatsocketioio.ui.login;

import android.text.TextUtils;
import android.util.Log;

import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;
import com.osp.projects.androidchatsocketioio.model.request.PostUserRequest;
import com.osp.projects.androidchatsocketioio.model.request.RegisterRequest;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinished{

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private String userNickname;
    private MySharedPreference mySharedPreference;

    public LoginPresenterImpl(LoginView loginView, MySharedPreference mySharedPreference) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.mySharedPreference = mySharedPreference;
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
    public void validateJoin(String userNickname) {
        if (TextUtils.isEmpty(userNickname)) {
            //txtUserName.setError("This field is required!!!! shit!!!!");
           // txtUserName.requestFocus();
            return;
        }
        this.userNickname = userNickname;
        PostUserRequest postUserRequest = new PostUserRequest();
        postUserRequest.setUserName(userNickname);
        loginInteractor.servicePostUser(postUserRequest, this);
    }

    @Override
    public void onSuccessful() {
        loginInteractor.serviceGetUserByNickname(userNickname, this);
    }

    @Override
    public void onSuccessfulGetUser(UserEntity userEntity) {
        mySharedPreference.storeUser(userEntity);
        loginView.navigateToMain();
    }

    @Override
    public void onError() {

    }

    @Override
    public void onFailure() {

    }
}
