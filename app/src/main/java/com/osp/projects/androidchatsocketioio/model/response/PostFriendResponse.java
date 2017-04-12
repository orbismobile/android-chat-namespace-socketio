package com.osp.projects.androidchatsocketioio.model.response;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/12/17.
 */

public class PostFriendResponse {


    /**
     * status : SUCCESS
     * message : Friend Inserted
     */

    private String status;
    private String message;

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
}
