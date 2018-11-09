package com.jpndev.dbapp.network.retrofit;

import com.jpndev.dbapp.db.model.Note;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiInterface {
/*
    @Multipart
    @Headers(
            {"support-app-id: appid","support-app-key: appkey","enctype: multipart/form-data"}
            )

    @POST("question")
    Call<SuccesMessage> getUploadedStatus(@Part("data") RequestBody data);
*/
/*
    @GET("/bitcoin")
    Call<MGraphRoot> getGraphBTCUsd();*/

 /*   @GET("/notes.php")
    public Call<Note> getNotes(@Url String url);*/

    @GET("jp_works/api_test//notes.php")
    public Call<List<Note>> getNotes();
}