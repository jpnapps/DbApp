package com.jpndev.dbapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("test, kkkkk!")

        button.setOnClickListener(
            View.OnClickListener {   myRef.setValue("db, ffffff!") }

        )
    }
    /*Remove the

implementation 'com.google.firebase:firebase-database:16.0.1:15.0.0'
and add only

implementation 'com.google.firebase:firebase-database:16.0.1'*/
}
