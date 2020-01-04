package com.example.paymentmethod

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class PacNumber : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pac_number)


        var sharedPreferences = getSharedPreferences("com.example.paymentmethod", Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().commit()
        val phonenumber = null
        val savephone = sharedPreferences.getString("SESSION_PHONE", phonenumber)

        //val phonenum = "0124925256"
        val phone = findViewById<TextView>(R.id.phonenumber)
        phone.setText(savephone)
        //sendpac()
    }




}
