package com.osp.projects.androidchatsocketioio.model.response;

import java.util.List;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 18/04/17.
 */

public class GetGroupMembersResponse {


    /**
     * status : SUCCESS
     * statusCode : 200
     * message : User was found
     * data : [{"groupId":3,"groupName":"TECHNOLOGY","userId":2,"friendId":2,"userName":"ronaldo"},{"groupId":3,"groupName":"TECHNOLOGY","userId":3,"friendId":3,"userName":"carlo"}]
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
         * groupId : 3
         * groupName : TECHNOLOGY
         * userId : 2
         * friendId : 2
         * userName : ronaldo
         */

        private int groupId;
        private String groupName;
        private int userId;
        private int friendId;
        private String userName;

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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

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
