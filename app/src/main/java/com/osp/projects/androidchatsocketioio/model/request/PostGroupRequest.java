package com.osp.projects.androidchatsocketioio.model.request;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 18/04/17.
 */

public class PostGroupRequest {


    /**
     * groupName : TECHNOLOGY
     * userId : 1
     * friendIds : [2,3]
     */

    private String groupName;
    private int userId;
    private List<Integer> friendIds;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getFriendIds() {
        return friendIds;
    }

    public void setFriendIds(List<Integer> friendIds) {
        this.friendIds = friendIds;
    }
}
