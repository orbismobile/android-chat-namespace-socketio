package com.osp.projects.androidchatsocketioio.model.entity;

import java.io.Serializable;

/**
 * Created by Carlos Vargas on 9/12/16.
 * CarlitosDroid
 */
public class RoomEntity implements Serializable {

    private String name;
    private String userName;
    private String description;
    private String date;
    private int imgDrawable;


    public RoomEntity(String name, String userName, String description, String date, int imgDrawable) {
        this.name = name;
        this.userName = userName;
        this.description = description;
        this.date = date;
        this.imgDrawable = imgDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(int imgDrawable) {
        this.imgDrawable = imgDrawable;
    }
}
