package com.osp.projects.androidchatsocketioio.model.response;

import java.util.List;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public class FriendsResponse {


    /**
     * message : friends were found successfully
     * data : [{"id_friend":2,"friend_name":"ronaldo"},{"id_friend":3,"friend_name":"eduardo"},{"id_friend":4,"friend_name":"jose"}]
     */

    private String message;
    /**
     * id_friend : 2
     * friend_name : ronaldo
     */

    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id_friend;
        private String friend_name;

        public int getId_friend() {
            return id_friend;
        }

        public void setId_friend(int id_friend) {
            this.id_friend = id_friend;
        }

        public String getFriend_name() {
            return friend_name;
        }

        public void setFriend_name(String friend_name) {
            this.friend_name = friend_name;
        }
    }
}
