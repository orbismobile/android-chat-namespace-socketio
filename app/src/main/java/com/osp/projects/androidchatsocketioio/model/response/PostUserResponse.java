package com.osp.projects.androidchatsocketioio.model.response;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 4/9/17.
 */

public class PostUserResponse {

    /**
     * status : SUCCESS
     * message : User Inserted
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
