package com.osp.projects.androidchatsocketioio.model.entity;

/**
 * Created by Carlos Vargas on 8/22/16.
 * CarlitosDroid
 */
public class MessageTypeActionEntity {

    private String userName;
    private String message;

    public MessageTypeActionEntity() {
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
