package com.osp.projects.androidchatsocketioio.model.response;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 */

public class GetUserByNicknameResponse {

    /**
     * status : SUCCESS
     * message : User was found
     * data : [{"userId":11,"userName":"seno"}]
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
         * userId : 11
         * userName : seno
         */

        private int userId;
        private String userName;

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
}
