package com.osp.projects.androidchatsocketioio.ui.main;

import android.util.Log;


import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.ui.login.LoginActivity;
import com.osp.projects.androidchatsocketioio.util.adapter.RoomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 *
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnGetFriendsFinished{

    private MainView mainView;
    private MainInteractor mainInteractor;
    private List<GetFriendsByUserIdResponse.DataBean> friendsBeanList = new ArrayList<>();

    private RoomAdapter roomAdapter;

    public MainPresenterImpl(MainView mainView){
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl();
        roomAdapter = new RoomAdapter(mainView, friendsBeanList);
    }

    @Override
    public void initialRestaurantData() {

    }

    @Override
    public void initialMenuOptionData() {

    }

    @Override
    public void configMenuOptionAdapter(LoginActivity mainActivity) {

    }

    @Override
    public void configRestaurantAdapter(LoginActivity mainActivity) {

    }

    @Override
    public void configRecyclerView() {
        mainView.configRecyclerView(roomAdapter);
    }

    @Override
    public List<GetFriendsByUserIdResponse.DataBean> getListFriends() {
        return friendsBeanList;

    }

    @Override
    public void serviceFriends(int userId) {
        mainInteractor.serviceGetFriendsByUserId(userId, this);
    }

    @Override
    public void onSuccessful(List<GetFriendsByUserIdResponse.DataBean> friendsBeanList) {
        if(friendsBeanList != null){
            this.friendsBeanList.clear();
            this.friendsBeanList.addAll(friendsBeanList);
            roomAdapter.notifyDataSetChanged();
            mainView.hideSwipeRefresh();
        }
    }

    @Override
    public void serviceGroups(int userId) {

    }

    @Override
    public void onSuccessfulGetGroup() {

    }


    @Override
    public void onError() {
        mainView.hideSwipeRefresh();
        Log.e("ERROR","ERROR");
    }

    @Override
    public void onFailure() {
        Log.e("FAILURE","FAILURE");
    }
}
