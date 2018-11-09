package com.jpndev.dbapp.db;

import com.jpndev.dbapp.db.model.Note;
import com.jpndev.dbapp.network.retrofit.ApiIClient;
import com.jpndev.dbapp.network.retrofit.ApiInterface;
import com.jpndev.dbapp.utility.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class dd {


    private void apiGetNoteList() {
        try{


            ApiInterface apiService = ApiIClient.getClient().create(ApiInterface.class);
            //	 RequestBody data = RequestBody.create(MediaType.parse("multipart/form-data"), json);
            LogUtils.LOGD("jithish","apiGetNoteList 1");
            Call<List<Note>> call = apiService.getNotes();
            LogUtils.LOGD("jithish","apiGetNoteList 2");
            call.enqueue(new Callback<List<Note>>() {

                @Override
                public void onResponse(Call<List<Note>> call, final Response<List<Note>> response) {
                    int statusCode = response.code();
                    //hideProgress();
                    LogUtils.LOGD("jithish","apiGetNoteList onResponse"+ statusCode);
                    try {

                        if(response.isSuccessful()) {

                            Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                    List<Note> notelist=response.body();


                                }

                            };
                            new Thread(runnable).start();
                        }
                    } catch (Exception e) {



                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<List<Note>> call, Throwable t) {
                    t.getMessage();
                    LogUtils.LOGD("jithish", "apiGetNoteList onFailure"+t.toString());
                    //hideProgress();
                }
            });






            LogUtils.LOGD("jithish","apiGetNoteList end ");
        }catch (Exception e)
        {
            LogUtils.LOGD("jithish","apiGetNoteList end exce"+e.getMessage());
            e.printStackTrace();
        }
    }


}
