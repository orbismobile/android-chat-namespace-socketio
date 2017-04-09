package com.osp.projects.androidchatsocketioio.ui.login;

import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToMain();

}
