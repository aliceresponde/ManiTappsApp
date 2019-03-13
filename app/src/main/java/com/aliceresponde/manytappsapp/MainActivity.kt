package com.aliceresponde.manytappsapp

import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var score = 0
    private val countDownInterval: Long = 1000 // 1s
    private var initialCountDown: Long = 60000 // 60s
    private lateinit var countDownTimer: CountDownTimer
    private var gameStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // link  java fields with  layout
        val game_score_text_view = findViewById<TextView>(R.id.game_score_text_view)
        val game_time_left = findViewById<TextView>(R.id.game_time_left)
        val game_tap_me_button = findViewById<Button>(R.id.game_tap_me_button)

        resetGame()
        game_tap_me_button.setOnClickListener {
            incrementScore()
        }
    }

    /**
     * set score in 0 and initialize the timer as for a minut count down
     */
    private fun resetGame() {
        var timeLeft = initialCountDown / 1000  // time in second
        score = 0
        game_score_text_view.text = getString(R.string.game_your_score, score.toString())
        game_time_left.text = getString(R.string.game_time_left, timeLeft.toString())

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onFinish() {
                endGame()
            }

            //update left time label
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                game_time_left.text = getString(R.string.game_time_left, timeLeft.toString())
            }
        }
        gameStarted = false
    }

    /**
     * Show score to user, and reset screen (timer 60, score 0)
     */
    private fun endGame() {
        Toast.makeText(this, getString(R.string.game_gae_over_message, score.toString()), Toast.LENGTH_LONG).show()
        resetGame()
    }

    /**
     * Start game if  needed, increment score and update score
     */
    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }

        score += 1
        val newScoreText = getString(R.string.game_your_score, score.toString())
        game_score_text_view.text = newScoreText
    }

    /**
     * Start timer decremental update  game flag
     */
    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }
}
