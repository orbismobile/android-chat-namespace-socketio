package com.osp.projects.androidchatsocketioio.ui.main;

import com.osp.projects.androidchatsocketioio.util.adapter.RoomAdapter;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 *
 */

public interface MainView {
    void navigateToMain(int itemPosition);
    void configRecyclerView(RoomAdapter roomAdapter);
    void hideSwipeRefresh();
}
