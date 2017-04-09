package com.osp.projects.androidchatsocketioio.model.response;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 */

public class GetFriendsByUserIdResponse {

    /**
     * status : SUCCESS
     * message : Friend were found
     * friends : [{"id_user":1,"friend_name":"eduardo"},{"id_user":1,"friend_name":"wallo"},{"id_user":1,"friend_name":"alexis"}]
     */

    private String status;
    private String message;
    private List<FriendsBean> friends;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FriendsBean> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendsBean> friends) {
        this.friends = friends;
    }

    public static class FriendsBean {
        /**
         * id_user : 1
         * friend_name : eduardo
         */

        private int id_user;
        private String friend_name;

        public int getId_user() {
            return id_user;
        }

        public void setId_user(int id_user) {
            this.id_user = id_user;
        }

        public String getFriend_name() {
            return friend_name;
        }

        public void setFriend_name(String friend_name) {
            this.friend_name = friend_name;
        }
    }
}
