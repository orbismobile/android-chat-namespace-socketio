package com.osp.projects.androidchatsocketioio.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.entity.RoomEntity;
import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;
import com.osp.projects.androidchatsocketioio.ui.globalfriend.GlobalFriendsActivity;
import com.osp.projects.androidchatsocketioio.ui.rooms.RoomActivity;
import com.osp.projects.androidchatsocketioio.util.Constants;
import com.osp.projects.androidchatsocketioio.util.adapter.RoomAdapter;


public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener{

    private Boolean isUserConnected = false;

    private RecyclerView rcvRooms;
    private LinearLayoutManager linearLayoutManager;

    private MainPresenter mainPresenter;
    private MySharedPreference mySharedPreference;

    private FloatingActionButton fabAddUser;
    private SwipeRefreshLayout swpRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fabAddUser = (FloatingActionButton) findViewById(R.id.fabAddUser);


        rcvRooms = (RecyclerView) findViewById(R.id.rcvRooms);
        swpRefresh = (SwipeRefreshLayout) findViewById(R.id.swpRefresh);
        linearLayoutManager = new LinearLayoutManager(this);
        rcvRooms.setLayoutManager(linearLayoutManager);

        mySharedPreference = new MySharedPreference(this);

        swpRefresh.setOnRefreshListener(this);

        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.configRecyclerView();
        //mainPresenter.serviceFriends(mySharedPreference.getUser().getUserId());

        fabAddUser.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void navigateToMain(int itemPosition) {
        Intent intent = new Intent(this, RoomActivity.class);
        GetFriendsByUserIdResponse.DataBean dataBean = mainPresenter.getListFriends().get(itemPosition);
        intent.putExtra(Constants.ROOM_ENTITY,  new RoomEntity(dataBean.getFriendId()+"ROOM", dataBean.getUserName(), "salutee" , "2012-01-20", R.drawable.ic_boy1));
        startActivity(intent);
    }

    @Override
    public void configRecyclerView(RoomAdapter roomAdapter) {
        rcvRooms.setAdapter(roomAdapter);
    }

    @Override
    public void hideSwipeRefresh() {
        if(swpRefresh.isRefreshing()){
            swpRefresh.setRefreshing(false);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fabAddUser:
                startActivity(new Intent(this, GlobalFriendsActivity.class));
//                FragmentManager fm = this.getSupportFragmentManager();
//                AddUserDialogFragment addUserDialogFragment =
//                        AddUserDialogFragment.newInstance("test","test");
//                addUserDialogFragment.show(fm, "carlitois");
                break;
        }
    }

    @Override
    public void onRefresh() {
        mainPresenter.serviceFriends(mySharedPreference.getUser().getUserId());
    }
}
