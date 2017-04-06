package com.osp.projects.androidchatsocketioio.ui.login;

import android.util.Log;

import com.google.gson.Gson;
import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;
import com.osp.projects.androidchatsocketioio.model.request.RegisterRequest;
import com.osp.projects.androidchatsocketioio.model.response.RegisterResponse;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;
import com.osp.projects.androidchatsocketioio.util.api.ChatRoomApiManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void serviceLogin(final RegisterRequest registerRequest, final OnLoginFinished listener) {
        Call<RegisterResponse> call = ChatRoomApiManager.apiManager().registerPost(registerRequest);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {

                    Log.e("VEAMOS ", "VEAMOS " + new Gson().toJson(response.body()));
                    RegisterResponse registerResponse = response.body();

                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserId(registerResponse.getId_user());
                    userEntity.setUserName(registerRequest.getUser_name());
                    userEntity.setUserRoom(registerRequest.getUser_name() + "Room");

                    listener.onSuccessful(userEntity);

                } else {
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                listener.onFailure();
            }
        });

    }

}
