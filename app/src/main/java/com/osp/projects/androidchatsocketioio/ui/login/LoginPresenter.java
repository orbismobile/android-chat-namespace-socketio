package com.osp.projects.androidchatsocketioio.ui.login;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 */

public interface LoginPresenter {
    void initialRestaurantData();
    void initialMenuOptionData();
    void configMenuOptionAdapter(LoginActivity mainActivity);
    void configRestaurantAdapter(LoginActivity mainActivity);
    void validateJoin(String userNickname);
}
