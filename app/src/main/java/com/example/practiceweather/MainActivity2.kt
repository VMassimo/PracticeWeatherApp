package com.example.practiceweather

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text = intent.getStringExtra("text")
        val textView = findViewById<TextView>(R.id.cityTextView)
        textView.text = text

        val mediaPlayer = MediaPlayer.create(this, R.raw.rain)

        val statusTextView = findViewById<TextView>(R.id.statusTextView)
        val playButton = findViewById<Button>(R.id.playButton)
        val pauseButton = findViewById<Button>(R.id.pauseButton)

        playButton.setOnClickListener {
            mediaPlayer.start()
            statusTextView.text = "Status: Playing"
        }

        pauseButton.setOnClickListener {
            mediaPlayer.pause()
            statusTextView.text = "Status: Paused"
        }

    }
}