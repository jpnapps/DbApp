package com.jpndev.dbapp

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jpndev.dbapp.db.model.Note
import com.jpndev.dbapp.network.retrofit.ApiIClient
import com.jpndev.dbapp.network.retrofit.ApiInterface
import com.jpndev.dbapp.ui.AdapterRcvNoteItem
import com.jpndev.dbapp.utility.LogUtils
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    var notelist:List<Note>?=null
    var adapter: AdapterRcvNoteItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        rcv.setLayoutManager(LinearLayoutManager(this@ListActivity))
        apiGetNoteList()

    }

    private fun setAdapter() {
        notelist?.let {
        adapter = AdapterRcvNoteItem(this,notelist)

        // rcv.setL = LinearLayoutManager(this@ShopMineActivityKt)
        rcv.setAdapter(adapter)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                rcv.setOnScrollChangeListener(View.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                    flay.isSelected = rcv.canScrollVertically(-1);
                   // close_dimv.isSelected = rcv.canScrollVertically(-1);


                })
            }


        }
    }
/* /*   scv.isSelected = rcv.canScrollVertically(-1);
                    white_view.isSelected = rcv.canScrollVertically(-1);*/*/
    private fun apiGetNoteList() {
        try {


            val apiService = ApiIClient.getClient().create(ApiInterface::class.java)
            //	 RequestBody data = RequestBody.create(MediaType.parse("multipart/form-data"), json);
            LogUtils.LOGD("jithish", "apiGetNoteList 1")
            val call = apiService.notes
            LogUtils.LOGD("jithish", "apiGetNoteList 2")
            call.enqueue(object : Callback<List<Note>> {

                override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {
                    val statusCode = response.code()
                    //hideProgress();
                    LogUtils.LOGD("jithish", "apiGetNoteList onResponse$statusCode")
                    try {

                        if (response.isSuccessful) {
                            notelist = response.body()
                            setAdapter()

//                            val runnable = Runnable { }
//                            Thread(runnable).start()
                        }
                    } catch (e: Exception) {


                        e.printStackTrace()
                    }

                }

                override fun onFailure(call: Call<List<Note>>, t: Throwable) {
                    t.message
                    LogUtils.LOGD("jithish", "apiGetNoteList onFailure" + t.toString())
                    //hideProgress();
                }
            })






            LogUtils.LOGD("jithish", "apiGetNoteList end ")
        } catch (e: Exception) {
            LogUtils.LOGD("jithish", "apiGetNoteList end exce" + e.message)
            e.printStackTrace()
        }

    }
}
