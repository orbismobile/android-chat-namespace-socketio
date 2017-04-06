package com.osp.projects.androidchatsocketioio.ui.login;

import android.text.TextUtils;

import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;
import com.osp.projects.androidchatsocketioio.model.request.RegisterRequest;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinished{



    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
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

        RegisterRequest registerRequest = new RegisterRequest(userNickname, userNickname+"Room");
        loginInteractor.serviceLogin(registerRequest, this);
    }

    @Override
    public void onSuccessful(UserEntity userEntity) {
        loginView.navigateToMain(userEntity);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onFailure() {

    }
}
