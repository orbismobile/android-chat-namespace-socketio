package com.osp.projects.androidchatsocketioio.util.api;

import com.osp.projects.androidchatsocketioio.model.request.PostUserRequest;
import com.osp.projects.androidchatsocketioio.model.request.RegisterRequest;
import com.osp.projects.androidchatsocketioio.model.response.FriendsResponse;
import com.osp.projects.androidchatsocketioio.model.response.GetFriendsByUserIdResponse;
import com.osp.projects.androidchatsocketioio.model.response.GetUserByNicknameResponse;
import com.osp.projects.androidchatsocketioio.model.response.GetUserResponse;
import com.osp.projects.androidchatsocketioio.model.response.PostUserResponse;
import com.osp.projects.androidchatsocketioio.model.response.RegisterResponse;
import com.osp.projects.androidchatsocketioio.model.response.RoomsResponse;
import com.osp.projects.androidchatsocketioio.util.EndPointConstant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Carlos Vargas on 10/1/16.
 * CarlitosDroid
 */

public interface ChatDemoApi {

    @GET(EndPointConstant.GET_USER)
    Call<GetUserResponse> getUser();
    @GET(EndPointConstant.GET_USER_BY_NICKNAME)
    Call<GetUserByNicknameResponse> getUserByNickname(@Path("userNickname") String nickname);
    @GET(EndPointConstant.GET_FRIENDS_BY_USER_ID)
    Call<GetFriendsByUserIdResponse> getFriendsByUserId(@Path("userId") int id);
    @POST(EndPointConstant.POST_USER)
    Call<PostUserResponse> postUser(@Body PostUserRequest postUserRequest);



    @GET(EndPointConstant.URL_FRIENDS)
    Call<FriendsResponse> friendsGet(@Path("user_id") int id);


    @GET(EndPointConstant.URL_ROOMS)
    Call<RoomsResponse> roomsGet(@Path("user_id") int id);


    @POST(EndPointConstant.URL_REGISTER)
    Call<RegisterResponse> registerPost(@Body RegisterRequest registerRequest);



}
