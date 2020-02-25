package com.example.teamwork;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiCalls {


    @FormUrlEncoded
    @POST("/v1/auth/signin")
    Call<ResponseBody> UserLogin(
      @Field("email") String Email,
      @Field("password") String Password


    );

}
