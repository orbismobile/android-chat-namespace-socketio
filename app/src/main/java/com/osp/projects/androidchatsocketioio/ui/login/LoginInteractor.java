package com.osp.projects.androidchatsocketioio.ui.login;


import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;
import com.osp.projects.androidchatsocketioio.model.request.PostUserRequest;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public interface LoginInteractor {

    interface OnLoginFinished {
        void onSuccessfulGetUser(UserEntity userEntity);
        void onSuccessful();
        void onError();
        void onFailure();
    }

    void serviceGetUser(OnLoginFinished listener);
    void serviceGetUserByNickname(String nickname, OnLoginFinished listener);
    void serviceGetFriendsByUserId(OnLoginFinished listener);
    void servicePostUser(PostUserRequest postUserRequest, OnLoginFinished listener);
}
