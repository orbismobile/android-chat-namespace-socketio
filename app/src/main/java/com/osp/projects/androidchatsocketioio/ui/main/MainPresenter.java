package com.osp.projects.androidchatsocketioio.ui.main;

import com.osp.projects.androidchatsocketioio.ui.login.LoginActivity;
import com.osp.projects.androidchatsocketioio.util.adapter.RoomAdapter;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 */

public interface MainPresenter {
    void initialRestaurantData();
    void initialMenuOptionData();
    void configMenuOptionAdapter(LoginActivity mainActivity);
    void configRestaurantAdapter(LoginActivity mainActivity);
    void configRecyclerView();


    void serviceFriends(int userId);
}
