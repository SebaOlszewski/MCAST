package com.example.eggtimer

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var seekBar: SeekBar

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //this line builds the code to the images

        btnStart = findViewById(R.id.start)
        seekBar = findViewById(R.id.sbTimer)

        seekBar.max = 600
        seekBar.progress = 100

    }
}