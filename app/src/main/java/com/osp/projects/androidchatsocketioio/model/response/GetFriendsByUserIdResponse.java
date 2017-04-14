package com.osp.projects.androidchatsocketioio.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 */

public class GetFriendsByUserIdResponse {


    /**
     * status : SUCCESS
     * statusCode : 200
     * message : Friend were found
     * data : [{"friendId":0,"userName":"DefaultNamespace"},{"linkId":1,"friendId":2,"userName":"ronaldo"},{"linkId":2,"friendId":3,"userName":"carlo"},{"linkId":6,"friendId":4,"userName":"ricardo"}]
     */

    private String status;
    private int statusCode;
    private String message;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

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

    public static class DataBean implements Serializable{
        /**
         * friendId : 0
         * userName : DefaultNamespace
         * linkId : 1
         */

        private int friendId;
        private String userName;
        private int linkId;

        public int getFriendId() {
            return friendId;
        }

        public void setFriendId(int friendId) {
            this.friendId = friendId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getLinkId() {
            return linkId;
        }

        public void setLinkId(int linkId) {
            this.linkId = linkId;
        }
    }
}
