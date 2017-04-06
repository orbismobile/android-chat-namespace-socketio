package com.osp.projects.androidchatsocketioio.model.response;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public class RegisterResponse {


    /**
     * message : rooms were found successfully
     * id_user : 19
     * id_room : 8
     */

    private String message;
    private int id_user;
    private int id_room;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }
}
