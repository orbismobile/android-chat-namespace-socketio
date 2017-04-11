package com.osp.projects.androidchatsocketioio.ui.main;

import com.osp.projects.androidchatsocketioio.ui.login.LoginActivity;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 */

public interface MainPresenter {
    void initialRestaurantData();
    void initialMenuOptionData();
    void configMenuOptionAdapter(LoginActivity mainActivity);
    void configRestaurantAdapter(LoginActivity mainActivity);


    void serviceFriends(int userId);
}
