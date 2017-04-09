package com.osp.projects.androidchatsocketioio.util.api;

import com.osp.projects.androidchatsocketioio.util.EndPointConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public class ChatDemoApiManager {

    private static ChatDemoApi chatDemoApi;

    public static ChatDemoApi apiManager(){

        if(chatDemoApi == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(EndPointConstant.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            chatDemoApi = client.create(ChatDemoApi.class);
        }

        return chatDemoApi;
    }
}
