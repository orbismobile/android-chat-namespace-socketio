package com.osp.projects.androidchatsocketioio.util.api;

import com.osp.projects.androidchatsocketioio.util.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public class ChatRoomApiManager {

    private static ChatRoomApi chatRoomApi;

    public static ChatRoomApi apiManager(){

        if(chatRoomApi == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            chatRoomApi = client.create(ChatRoomApi.class);
        }

        return chatRoomApi;
    }
}
