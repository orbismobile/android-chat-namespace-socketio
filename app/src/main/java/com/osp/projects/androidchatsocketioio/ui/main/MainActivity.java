package com.osp.projects.androidchatsocketioio.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.model.entity.RoomEntity;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;
import com.osp.projects.androidchatsocketioio.ui.fragment.adduser.AddUserDialogFragment;
import com.osp.projects.androidchatsocketioio.ui.rooms.RoomActivity;
import com.osp.projects.androidchatsocketioio.ui.rooms.RoomPresenter;
import com.osp.projects.androidchatsocketioio.util.Constants;
import com.osp.projects.androidchatsocketioio.util.adapter.RoomAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.osp.projects.androidchatsocketioio.R.id.fab;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener{

    private Boolean isUserConnected = false;

    private RecyclerView rcvRooms;
    private LinearLayoutManager linearLayoutManager;
    private RoomAdapter roomAdapter;
    private List<RoomEntity> roomsList;

    private MainPresenter mainPresenter;
    private MySharedPreference mySharedPreference;

    private FloatingActionButton fabAddUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fabAddUser = (FloatingActionButton) findViewById(R.id.fabAddUser);


        rcvRooms = (RecyclerView) findViewById(R.id.rcvRooms);
        linearLayoutManager = new LinearLayoutManager(this);
        roomsList = new ArrayList<>();
        roomAdapter = new RoomAdapter(this, roomsList);

        rcvRooms.setLayoutManager(linearLayoutManager);
        rcvRooms.setAdapter(roomAdapter);

        /*
        roomsList.add(new RoomEntity("CarlosRoom", "Grupo de Carlos", "description", "12:36pm", R.drawable.ic_boy1));
        roomsList.add(new RoomEntity("LuisRoom", "Grupo de Luis", "description", "12:36pm", R.drawable.ic_boy2));
        roomsList.add(new RoomEntity("MaríaRoom", "Grupo de María", "description", "12:36pm", R.drawable.ic_girl));

        */

        //roomAdapter.notifyDataSetChanged();

        mySharedPreference = new MySharedPreference(this);

        //roomService(1);


        mainPresenter = new MainPresenterImpl(this);

        mainPresenter.serviceFriends(mySharedPreference.getUser().getUserId());

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
        intent.putExtra(Constants.ROOM_ENTITY, roomsList.get(itemPosition));
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fabAddUser:
                FragmentManager fm = this.getSupportFragmentManager();
                AddUserDialogFragment addUserDialogFragment =
                        AddUserDialogFragment.newInstance("test","test");
                addUserDialogFragment.show(fm, "carlitois");
                break;
        }
    }
}
