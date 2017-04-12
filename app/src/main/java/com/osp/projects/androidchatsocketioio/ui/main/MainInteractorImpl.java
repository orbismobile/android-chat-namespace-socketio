package com.osp.projects.androidchatsocketioio.ui.main;


import android.util.Log;

import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.util.api.ChatDemoApiManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 *
 */

public class MainInteractorImpl implements MainInteractor {

    @Override
    public void serviceGetFriendsByUserId(int userId, final OnGetFriendsFinished listener) {

        Call<GetFriendsByUserIdResponse> call = ChatDemoApiManager.apiManager().getFriendsByUserId(userId);
        call.enqueue(new Callback<GetFriendsByUserIdResponse>() {
            @Override
            public void onResponse(Call<GetFriendsByUserIdResponse> call, Response<GetFriendsByUserIdResponse> response) {
                if(response.isSuccessful()){
                    listener.onSuccessful(response.body().getData());
                }else{
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<GetFriendsByUserIdResponse> call, Throwable t) {
                listener.onFailure();
            }
        });

    }

}
