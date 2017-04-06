package com.osp.projects.androidchatsocketioio.model.request;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public class RegisterRequest {


    /**
     * user_name : MUAJAJA
     * room_name : MUAJAJAROOM
     */

    private String user_name;
    private String room_name;

    public RegisterRequest(String user_name, String room_name) {
        this.user_name = user_name;
        this.room_name = room_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}
