package com.osp.projects.androidchatsocketioio.model.response;

import java.util.List;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public class RoomsResponse {


    /**
     * message : rooms were found successfully
     * data : [{"id_room":2,"room_name":"ronaldoRoom"},{"id_room":3,"room_name":"eduardoRoom"},{"id_room":4,"room_name":"joseRoom"}]
     */

    private String message;
    /**
     * id_room : 2
     * room_name : ronaldoRoom
     */

    private List<DataBean> data;

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
        private int id_room;
        private String room_name;

        public int getId_room() {
            return id_room;
        }

        public void setId_room(int id_room) {
            this.id_room = id_room;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }
    }
}
