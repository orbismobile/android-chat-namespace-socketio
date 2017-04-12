package com.osp.projects.androidchatsocketioio.model.response;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 */

public class GetFriendsByUserIdResponse {


    /**
     * status : SUCCESS
     * message : Friend were found
     * data : [{"friendId":1,"userName":"carlos"},{"friendId":3,"userName":"carlo"},{"friendId":4,"userName":"ricardo"}]
     */

    private String status;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * friendId : 1
         * userName : carlos
         */

        private int friendId;
        private String userName;

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
    }
}
