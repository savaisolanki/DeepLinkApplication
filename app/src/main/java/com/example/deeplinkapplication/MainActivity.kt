package com.example.deeplinkapplication

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.deeplinkapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val intentData: Uri? = intent.data

        if (intentData != null) {

            val path = intentData
            Log.d(TAG, "onCreate: $path")


            val name = intentData.getQueryParameter("name")
            val age = intentData.getQueryParameter("age")

            binding.tvHello.text = name
            binding.tvBrainVire.text = age

            Toast.makeText(this, "Data : $path", Toast.LENGTH_SHORT).show()
        }
        //adb shell am start -W -a android.intent.action.VIEW -d "http://deeplink"
       // adb shell 'am start -W -a android.intent.action.VIEW -d "http://deeplink.com?name=savai&age=20"'

    }
}