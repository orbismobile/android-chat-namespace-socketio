package com.osp.projects.androidchatsocketioio.util.api;


import com.osp.projects.androidchatsocketioio.model.request.RegisterRequest;
import com.osp.projects.androidchatsocketioio.model.response.FriendsResponse;
import com.osp.projects.androidchatsocketioio.model.response.RegisterResponse;
import com.osp.projects.androidchatsocketioio.model.response.RoomsResponse;
import com.osp.projects.androidchatsocketioio.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public interface ChatRoomApi {

    @GET(Constants.URL_FRIENDS)
    Call<FriendsResponse> friendsGet(@Path("user_id") int id);


    @GET(Constants.URL_ROOMS)
    Call<RoomsResponse> roomsGet(@Path("user_id") int id);


    @POST(Constants.URL_REGISTER)
    Call<RegisterResponse> registerPost(@Body RegisterRequest registerRequest);

}
