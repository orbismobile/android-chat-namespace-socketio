package com.osp.projects.androidchatsocketioio.ui.main;

import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.model.response.GetGroupsByUserId;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 *
 */

public interface MainInteractor {

    interface OnGetFriendsFinished {
        void onSuccessfulGetGroups(List<GetGroupsByUserId.DataBean> dataBeen);
        void onSuccessful(List<GetFriendsByUserIdResponse.DataBean> dataBeen);
        void onError();
        void onFailure();
    }

    void serviceGetFriendsByUserId(int userId, OnGetFriendsFinished listener);
    void serviceGetGroupsByUserId(int userId, OnGetFriendsFinished listener);

}
