package com.osp.projects.androidchatsocketioio.ui.fragment.adduser;

import com.osp.projects.androidchatsocketioio.ui.main.MainInteractor;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 11/04/17.
 *
 */

public class AddUserInteractorImpl implements AddUserInteractor {

    @Override
    public void serviceGetFriendsByUserId(final MainInteractor.OnGetFriendsFinished ){

    }


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


}
