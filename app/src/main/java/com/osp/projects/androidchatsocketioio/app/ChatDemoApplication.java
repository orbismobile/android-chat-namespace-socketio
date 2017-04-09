package com.osp.projects.androidchatsocketioio.app;

import android.app.Application;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.osp.projects.androidchatsocketioio.util.EndPointConstant;

import java.net.URISyntaxException;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 *
 */

public class ChatDemoApplication extends Application{
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket(EndPointConstant.BASE_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
