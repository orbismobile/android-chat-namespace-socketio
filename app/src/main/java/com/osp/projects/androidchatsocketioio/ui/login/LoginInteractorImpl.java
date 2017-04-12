package com.osp.projects.androidchatsocketioio.ui.login;

import android.util.Log;

import com.google.gson.Gson;
import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;
import com.osp.projects.androidchatsocketioio.model.request.PostUserRequest;
import com.osp.projects.androidchatsocketioio.model.request.RegisterRequest;
import com.osp.projects.androidchatsocketioio.model.response.GetUserByNicknameResponse;
import com.osp.projects.androidchatsocketioio.model.response.GetUserResponse;
import com.osp.projects.androidchatsocketioio.model.response.PostUserResponse;
import com.osp.projects.androidchatsocketioio.model.response.RegisterResponse;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;
import com.osp.projects.androidchatsocketioio.util.api.ChatDemoApiManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void serviceGetUser(final OnLoginFinished listener) {
        Call<GetUserResponse> call = ChatDemoApiManager.apiManager().getUser();
        call.enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                if (response.isSuccessful()) {
                    GetUserResponse getUserResponse  = response.body();

                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserId(getUserResponse.getData().get(0).getId_user());
                    userEntity.setUserName(getUserResponse.getData().get(0).getUser_name());
                    listener.onSuccessfulGetUser(userEntity);

                } else {
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

    @Override
    public void serviceGetUserByNickname(String nickname, final OnLoginFinished listener) {
        Call<GetUserByNicknameResponse> call = ChatDemoApiManager.apiManager().getUserByNickname(nickname);
        call.enqueue(new Callback<GetUserByNicknameResponse>() {
            @Override
            public void onResponse(Call<GetUserByNicknameResponse> call, Response<GetUserByNicknameResponse> response) {
                if (response.isSuccessful()) {
                    GetUserByNicknameResponse getUserByNicknameResponse  = response.body();

                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserId(getUserByNicknameResponse.getData().get(0).getUserId());
                    userEntity.setUserName(getUserByNicknameResponse.getData().get(0).getUserName());

                    listener.onSuccessfulGetUser(userEntity);

                } else {
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<GetUserByNicknameResponse> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

    @Override
    public void serviceGetFriendsByUserId(OnLoginFinished listener) {

    }

    @Override
    public void servicePostUser(PostUserRequest postUserRequest, final OnLoginFinished listener) {
        Call<PostUserResponse> call = ChatDemoApiManager.apiManager().postUser(postUserRequest);
        call.enqueue(new Callback<PostUserResponse>() {
            @Override
            public void onResponse(Call<PostUserResponse> call, Response<PostUserResponse> response) {
                if (response.isSuccessful()) {

                    Log.e("VEAMOS ", "VEAMOS " + new Gson().toJson(response.body()));
                    PostUserResponse postUserResponse = response.body();
                    listener.onSuccessful();

                } else {
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<PostUserResponse> call, Throwable t) {
                listener.onFailure();
            }
        });

    }
}
