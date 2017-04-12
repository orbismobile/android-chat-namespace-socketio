package com.osp.projects.androidchatsocketioio.model.request;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/11/17.
 */

public class PostFriendRequest {


    /**
     * friendId : 1
     * userId : 5
     */

    private int friendId;
    private int userId;

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
