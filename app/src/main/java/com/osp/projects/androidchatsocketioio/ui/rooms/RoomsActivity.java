package com.osp.projects.androidchatsocketioio.ui.rooms;

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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.app.ChatDemoApplication;
import com.osp.projects.androidchatsocketioio.model.entity.RoomEntity;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;
import com.osp.projects.androidchatsocketioio.ui.main.MainActivity;
import com.osp.projects.androidchatsocketioio.util.Constants;
import com.osp.projects.androidchatsocketioio.util.adapter.MessageAdapter;
import com.osp.projects.androidchatsocketioio.util.adapter.RoomsAdapter;


import java.util.ArrayList;
import java.util.List;

public class RoomsActivity extends AppCompatActivity implements RoomsView, View.OnClickListener {
    /**RCV**/
    private RecyclerView rcvMessage;
    private MessageAdapter messageAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<Object> objectList;

    private ImageButton imgBtnSend;
    private EditText txtMessage;

    private Bundle bundle;
    private RoomEntity roomEntity;


    private Boolean isUserConnected = false;

    private Socket socket;
    private String roomOfUser;

    private MySharedPreference mySharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtMessage = (EditText) findViewById(R.id.txtMessage);
        imgBtnSend = (ImageButton) findViewById(R.id.imgBtnSend);
        rcvMessage = (RecyclerView) findViewById(R.id.rcvMessage);
        linearLayoutManager = new LinearLayoutManager(this);
        objectList = new ArrayList<>();
        messageAdapter = new MessageAdapter(objectList);
        rcvMessage.setLayoutManager(linearLayoutManager);
        rcvMessage.setAdapter(messageAdapter);


        mySharedPreference = new MySharedPreference(this);

        bundle = getIntent().getExtras();
        if(bundle!=null){
            roomEntity = (RoomEntity) bundle.getSerializable(Constants.ROOM_ENTITY);
        }

        roomOfUser = roomEntity.getName();

        Log.e("VEAMOS ", "VEAMOS " + roomEntity.getName());

        ChatDemoApplication chatApplication = (ChatDemoApplication) getApplication();
        socket = chatApplication.getSocket();

        socket.on(Socket.EVENT_CONNECT, onConnect);
        socket.on(Socket.EVENT_DISCONNECT, onDisconnect);
        //socket.on(Constants.EVENT_UPDATE_CHAT, onUpdateChat);

        if(!socket.connected()){
            socket.connect();
        }

        assert imgBtnSend!=null;
        imgBtnSend.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        socket.disconnect();
        socket.off(Socket.EVENT_CONNECT, onConnect);
        socket.off(Socket.EVENT_DISCONNECT, onDisconnect);
        //socket.off(Socket.EVENT_DISCONNECT, onUpdateChat);
    }

    private Emitter.Listener onConnect = new Emitter.Listener(){
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(!isUserConnected) {
                        Log.e("x-ROOM OF USER ", "X-ROOM OF USER " + roomOfUser);
                        socket.emit("joinNewRoom", mySharedPreference.getUser().getUserName(), roomOfUser);
                        isUserConnected = true;
                    }
                }
            });
        }
    };


    private Emitter.Listener onDisconnect = new Emitter.Listener(){
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    isUserConnected = false;
                    Toast.makeText(RoomsActivity.this, "You're disconnected", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    @Override
    public void onClick(View v) {

    }
}
