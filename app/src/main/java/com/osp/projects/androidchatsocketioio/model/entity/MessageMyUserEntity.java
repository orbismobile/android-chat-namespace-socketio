package com.osp.projects.androidchatsocketioio.model.entity;

/**
 * Created by Carlos Vargas on 8/20/16.
 * CarlitosDroid
 */
public class MessageMyUserEntity {

    private String userName;
    private String message;

    public MessageMyUserEntity() {
    }

    public MessageMyUserEntity(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
