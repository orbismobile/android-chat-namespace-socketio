package com.osp.projects.androidchatsocketioio.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.osp.projects.androidchatsocketioio.model.entity.UserEntity;


/**
 * Created by Carlos Vargas on 9/11/16.
 * CarlitosDroid
 */
public class MySharedPreference {

    //Sharedpref file name
    private static final String PREF_NAME = "ChatRoomPreference";

    //All Shared Preferences Keys
    private static final String KEY_USER_NAME = "user_fake_name";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_ROOM = "user_room";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public MySharedPreference(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(PREF_NAME,
                    Context.MODE_PRIVATE);
        }
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void storeUser(UserEntity userEntity){
        editor.putInt(KEY_USER_ID, userEntity.getUserId());
        editor.putString(KEY_USER_NAME, userEntity.getUserName());
        //editor.putString(KEY_USER_ROOM, userEntity.getUserName());
        Log.e("MySharePreferences", "User "+ userEntity.getUserName() +" - "+ userEntity.getUserName()
                +" stored in shared preferences. ");
        editor.apply();
    }

    public UserEntity getUser() {
        return new UserEntity(sharedPreferences.getInt(KEY_USER_ID, -1),
                sharedPreferences.getString(KEY_USER_NAME, ""));
    }
}
