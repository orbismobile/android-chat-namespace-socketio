package com.osp.projects.androidchatsocketioio.model.entity;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/12/17.
 */

public class FriendEntity {
    int userId;
    String userName;

    public FriendEntity(int userId, String userName) {
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
