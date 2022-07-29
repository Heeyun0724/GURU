package com.example.guru

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView


class ReviewList : AppCompatActivity() {

    lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_list)
        textView2 = findViewById(R.id.textView2)
        var dbHelper: DBManager = DBManager(applicationContext, "REVIEW.db", null, 1)

        textView2.setText(dbHelper.getrvResult())
}}
