package com.osp.projects.androidchatsocketioio.util;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 6/04/17.
 *
 */

public class EndPointConstant {

    public static final String BASE_URL = "http://192.168.2.1:8123/";
    //public static final String BASE_URL = "http://192.168.1.35:8123/";


    public static final String GET_USER = "user";
    public static final String POST_USER = "user";
    public static final String GET_USER_BY_NICKNAME = "user/{userNickname}";
    public static final String GET_FRIENDS_BY_USER_ID = "user/{userId}/friends";

    public static final String GET_GLOBAL_FRIENDS = "user/{userId}/globalfriends";


    public static final String GET_GROUPS_BY_USER_ID = "user/{userId}/groups";
    public static final String POST_GROUPS_BY_USER_ID = "group";
    public static final String GET_GROUP_MEMBERS = "group/{groupId}/members";

    public static final String POST_FRIEND = "friend";

    public static final int TYPE_HEADER_VIEW = 1;
    public static final int TYPE_ITEM_MY_USER = 2;
    public static final int TYPE_TYPE_ACTION_VIEW = 3;
    public static final int TYPE_ITEM_OTHER_USER = 4;

}