package com.osp.projects.androidchatsocketioio.model.response;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 18/04/17.
 */

public class PostGroupResponse {


    /**
     * status : SUCCESS
     * statusCode : 201
     * message : GroupDetail added successful
     */

    private String status;
    private int statusCode;
    private String message;

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
}
