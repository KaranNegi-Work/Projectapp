package com.example.projectapp.Retrofit;

import com.example.projectapp.models.DBResponceBack;
import com.example.projectapp.models.LoginResponse;
import com.example.projectapp.models.UserDataModel;
import com.example.projectapp.models.UserLoginRequest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebService {
@POST("home/CreateUser")
    Call<DBResponceBack> CreateUser(@Body UserDataModel data);
@POST("home/userlogin")
    Call<LoginResponse> LogInRequest(@Body UserLoginRequest pass);
}
