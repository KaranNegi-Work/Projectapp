package com.example.projectapp.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    String BaseURL;
    public RetrofitClient(String BaseURL){
        this.BaseURL=BaseURL;
    }
    public Retrofit RetrofitClientObject(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit.Builder Builder=new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create(gson));
Retrofit retrofitClient=Builder.build();
        return retrofitClient;
    }
}
