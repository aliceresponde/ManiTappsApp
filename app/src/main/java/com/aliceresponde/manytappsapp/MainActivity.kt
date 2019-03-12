package com.aliceresponde.manytappsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // class properties
    private lateinit var tapButton: Button
    private lateinit var gameScoreTextView: TextView
    private  lateinit var  gameTimerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // link  java fields with  layout
        tapButton = findViewById(R.id.game_tap_me_button)
        gameScoreTextView = findViewById(R.id.game_score_text_view)
        gameTimerTextView = findViewById(R.id.game_time_left)
    }
}
