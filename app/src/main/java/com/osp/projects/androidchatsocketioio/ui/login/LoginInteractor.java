package com.osp.projects.androidchatsocketioio.ui.login;


import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;
import com.osp.projects.androidchatsocketioio.model.request.RegisterRequest;
import com.osp.projects.androidchatsocketioio.model.response.RegisterResponse;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public interface LoginInteractor {

    interface OnLoginFinished {
        void onSuccessful(UserEntity userEntity);
        void onError();
        void onFailure();
    }

    void serviceLogin(RegisterRequest registerRequest, OnLoginFinished listener);
}
