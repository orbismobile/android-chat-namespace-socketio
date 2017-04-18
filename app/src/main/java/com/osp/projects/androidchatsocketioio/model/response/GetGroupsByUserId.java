package com.osp.projects.androidchatsocketioio.model.response;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 18/04/17.
 */

public class GetGroupsByUserId {


    /**
     * status : SUCCESS
     * statusCode : 200
     * message : User was found
     * data : [{"userId":1,"groupId":3,"groupName":"TECHNOLOGY"},{"userId":1,"groupId":4,"groupName":"TECHNOLOGY"},{"userId":1,"groupId":5,"groupName":"TECHNOLOGY"},{"userId":1,"groupId":6,"groupName":"TECHNOLOGY"},{"userId":1,"groupId":7,"groupName":"TECHNOLOGY"}]
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

    public static class DataBean {
        /**
         * userId : 1
         * groupId : 3
         * groupName : TECHNOLOGY
         */

        private int userId;
        private int groupId;
        private String groupName;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }
    }
}
