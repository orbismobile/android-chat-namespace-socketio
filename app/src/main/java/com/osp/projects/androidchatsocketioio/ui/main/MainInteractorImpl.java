package com.osp.projects.androidchatsocketioio.ui.main;


import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.model.response.GetGroupsByUserId;
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


    /*
    @Override
    public void servicePostGroup(PostGroupRequest postGroupRequest, final OnGetFriendsFinished listener) {

        Call<PostGroupResponse> call = ChatDemoApiManager.apiManager().postGroup(postGroupRequest);
        call.enqueue(new Callback<PostGroupResponse>() {
            @Override
            public void onResponse(Call<PostGroupResponse> call, Response<PostGroupResponse> response) {
                if(response.isSuccessful()){
                    listener.onSucc(response.body().getMessage());
                }else{
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<PostGroupResponse> call, Throwable t) {
                listener.onFailure();
            }
        });

    }*/


    @Override
    public void serviceGetGroupsByUserId(int userId, final OnGetFriendsFinished listener) {

        Call<GetGroupsByUserId> call = ChatDemoApiManager.apiManager().getGroupByUserId(userId);
        call.enqueue(new Callback<GetGroupsByUserId>() {
            @Override
            public void onResponse(Call<GetGroupsByUserId> call, Response<GetGroupsByUserId> response) {
                if(response.isSuccessful()){
                    listener.onSuccessfulGetGroups(response.body().getData());
                }else{
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<GetGroupsByUserId> call, Throwable t) {
                listener.onFailure();
            }
        });



    }



}
