package com.example.practiceweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextPagebutton = findViewById<Button>(R.id.nextPageButton)
        val searchText = findViewById<EditText>(R.id.searchText)
        val saveButton = findViewById<Button>(R.id.saveButton)



        nextPagebutton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        saveButton.setOnClickListener {
            val text = searchText.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("text", text)
            startActivity(intent)
        }




    }
}