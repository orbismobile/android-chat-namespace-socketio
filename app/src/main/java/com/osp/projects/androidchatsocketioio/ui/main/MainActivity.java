package com.osp.projects.androidchatsocketioio.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.app.ChatDemoApplication;
import com.osp.projects.androidchatsocketioio.model.entity.RoomEntity;
import com.osp.projects.androidchatsocketioio.ui.rooms.RoomsActivity;
import com.osp.projects.androidchatsocketioio.ui.rooms.RoomsPresenter;
import com.osp.projects.androidchatsocketioio.util.Constants;
import com.osp.projects.androidchatsocketioio.util.adapter.MessageAdapter;
import com.osp.projects.androidchatsocketioio.util.adapter.RoomsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private Boolean isUserConnected = false;

    private RecyclerView rcvRooms;
    private LinearLayoutManager linearLayoutManager;
    private RoomsAdapter roomsAdapter;
    private List<RoomEntity> roomsList;

    private RoomsPresenter roomsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rcvRooms = (RecyclerView) findViewById(R.id.rcvRooms);
        linearLayoutManager = new LinearLayoutManager(this);
        roomsList = new ArrayList<>();
        roomsAdapter = new RoomsAdapter(this, roomsList);

        rcvRooms.setLayoutManager(linearLayoutManager);
        rcvRooms.setAdapter(roomsAdapter);


        roomsList.add(new RoomEntity("CarlosRoom", "Grupo de Carlos", "description", "12:36pm", R.drawable.ic_boy1));
        roomsList.add(new RoomEntity("LuisRoom", "Grupo de Luis", "description", "12:36pm", R.drawable.ic_boy2));
        roomsList.add(new RoomEntity("MaríaRoom", "Grupo de María", "description", "12:36pm", R.drawable.ic_girl));

        roomsAdapter.notifyDataSetChanged();

        //roomService(1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        Intent intent = new Intent(this, RoomsActivity.class);
        intent.putExtra(Constants.ROOM_ENTITY, roomsList.get(itemPosition));
        startActivity(intent);
    }
}
