package com.osp.projects.androidchatsocketioio.model.entity;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public class UserEntity {

    private int userId;
    private String userName;


    public UserEntity() {
    }

    public UserEntity(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
