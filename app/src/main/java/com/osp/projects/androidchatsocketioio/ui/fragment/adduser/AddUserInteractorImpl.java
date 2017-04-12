package com.osp.projects.androidchatsocketioio.ui.fragment.adduser;

import com.osp.projects.androidchatsocketioio.model.request.PostFriendRequest;
import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.model.response.PostFriendResponse;
import com.osp.projects.androidchatsocketioio.util.api.ChatDemoApiManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 11/04/17.
 *
 */

public class AddUserInteractorImpl implements AddUserInteractor {

    @Override
    public void serviceAddUser(PostFriendRequest postFriendRequest, final OnAddUserFinished listener) {
        Call<PostFriendResponse> call = ChatDemoApiManager.apiManager().postFriend(postFriendRequest);
        call.enqueue(new Callback<PostFriendResponse>() {
            @Override
            public void onResponse(Call<PostFriendResponse> call, Response<PostFriendResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccessful();
                } else {
                    listener.onError();
                }
            }

            @Override
            public void onFailure(Call<PostFriendResponse> call, Throwable t) {
                listener.onFailure();
            }
        });
    }
}
