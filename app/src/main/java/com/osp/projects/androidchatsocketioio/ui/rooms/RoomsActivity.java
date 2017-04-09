package com.osp.projects.androidchatsocketioio.ui.rooms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.nkzawa.socketio.client.Socket;
import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.app.ChatDemoApplication;
import com.osp.projects.androidchatsocketioio.model.entity.RoomEntity;
import com.osp.projects.androidchatsocketioio.util.adapter.RoomsAdapter;


import java.util.ArrayList;
import java.util.List;

public class RoomsActivity extends AppCompatActivity {
    private Boolean isUserConnected = false;


    private RecyclerView rcvRooms;
    private LinearLayoutManager linearLayoutManager;
    private RoomsAdapter roomsAdapter;
    private List<RoomEntity> roomsList;

    private Socket socket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
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

        ChatDemoApplication chatApplication = (ChatDemoApplication) getApplication();
        socket = chatApplication.getSocket();

//        socket.on(Socket.EVENT_CONNECT, onConnect);
//        socket.on(Socket.EVENT_DISCONNECT, onDisconnect);
//
//        roomService(1);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
