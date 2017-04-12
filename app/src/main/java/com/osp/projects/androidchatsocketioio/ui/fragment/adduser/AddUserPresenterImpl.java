package com.osp.projects.androidchatsocketioio.ui.fragment.adduser;

import android.util.Log;

import com.osp.projects.androidchatsocketioio.model.request.PostFriendRequest;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 11/04/17.
 *
 */

public class AddUserPresenterImpl implements AddUserPresenter, AddUserInteractor.OnAddUserFinished {

    private AddUserView addUserView;
    private AddUserInteractor addUserInteractor;

    public AddUserPresenterImpl(AddUserView addUserView){
        this.addUserView = addUserView;
        this.addUserInteractor = new AddUserInteractorImpl();
    }

    @Override
    public void validateAddUser(int friendId, int userId) {
        PostFriendRequest postFriendRequest = new PostFriendRequest();
        postFriendRequest.setFriendId(friendId);
        postFriendRequest.setUserId(userId);
        addUserInteractor.serviceAddUser(postFriendRequest, this);
    }

    @Override
    public void onSuccessful() {
        Log.e("ONSUCCESS ","ONSUCCESS ");
    }

    @Override
    public void onError() {
        Log.e("ONERROR","ONERROR");
    }

    @Override
    public void onFailure() {
        Log.e("ONFAILURE","ONFAILURE");
    }

}
