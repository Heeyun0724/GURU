package com.example.guru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class InfoLibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_library)

        val button : Button = findViewById(R.id.button)
        val text : TextView = findViewById(R.id.textView)

        button.setOnClickListener{
            text.setText("- 신예린, 안현서, 윤희서, 허희윤 -")
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}