package com.osp.projects.androidchatsocketioio.ui.globalfriend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.request.PostFriendRequest;
import com.osp.projects.androidchatsocketioio.model.response.GetGlobalFriendsResponse;
import com.osp.projects.androidchatsocketioio.model.response.PostFriendResponse;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;
import com.osp.projects.androidchatsocketioio.util.api.ChatDemoApiManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalFriendsActivity extends AppCompatActivity {

    private RecyclerView rcvGlobalFriend;

    private LinearLayoutManager linearLayoutManager;
    private GlobalFriendAdapter globalFriendAdapter;
    private List<GetGlobalFriendsResponse.DataBean> dataBeanList = new ArrayList<>();

    MySharedPreference mySharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_friends);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rcvGlobalFriend = (RecyclerView) findViewById(R.id.rcvGlobalFriend);
        mySharedPreference = new MySharedPreference(this);
        linearLayoutManager = new LinearLayoutManager(this);

        globalFriendAdapter = new GlobalFriendAdapter(this, dataBeanList);

        rcvGlobalFriend.setLayoutManager(linearLayoutManager);
        rcvGlobalFriend.setAdapter(globalFriendAdapter);

        serviceGetGlobalFriend();

    }

    public void serviceGetGlobalFriend(){
        Call<GetGlobalFriendsResponse> call = ChatDemoApiManager.apiManager()
                .getGlobalFriends(mySharedPreference.getUser().getUserId());

        call.enqueue(new Callback<GetGlobalFriendsResponse>() {
            @Override
            public void onResponse(Call<GetGlobalFriendsResponse> call, Response<GetGlobalFriendsResponse> response) {
                dataBeanList.addAll(response.body().getData());
                globalFriendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetGlobalFriendsResponse> call, Throwable t) {

            }
        });
    }

    public void servicePostUser(int itemPosition){
        PostFriendRequest postFriendRequest = new PostFriendRequest();
        postFriendRequest.setFriendId(dataBeanList.get(itemPosition).getUserId());
        postFriendRequest.setUserId(mySharedPreference.getUser().getUserId());

        Call<PostFriendResponse> call = ChatDemoApiManager.apiManager()
                .postFriend(postFriendRequest);

        call.enqueue(new Callback<PostFriendResponse>() {
            @Override
            public void onResponse(Call<PostFriendResponse> call, Response<PostFriendResponse> response) {
                finish();
            }

            @Override
            public void onFailure(Call<PostFriendResponse> call, Throwable t) {

            }
        });

    }

}
