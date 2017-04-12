package com.osp.projects.androidchatsocketioio.ui.fragment.adduser;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 11/04/17.
 *
 */

public interface AddUserInteractor {

    interface OnAddUserFinished {
        void onSuccessfulGetUser();
        void onSuccessful();
        void onError();
        void onFailure();
    }

    void serviceAddUser(OnAddUserFinished listener);
}
