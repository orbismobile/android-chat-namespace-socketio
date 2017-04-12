package com.osp.projects.androidchatsocketioio.ui.fragment.adduser;

import com.osp.projects.androidchatsocketioio.model.request.PostFriendRequest;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 11/04/17.
 *
 */

public interface AddUserInteractor {

    interface OnAddUserFinished {
        void onSuccessful();
        void onError();
        void onFailure();
    }

    void serviceAddUser(PostFriendRequest postFriendRequest, OnAddUserFinished listener);
}
