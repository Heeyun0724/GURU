package com.example.guru

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*

class ReviewWrite : AppCompatActivity() {

     lateinit var bookName: EditText
     lateinit var star : EditText
     lateinit var review: EditText

     lateinit var completeButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_write)

        bookName = findViewById(R.id.bookname)
        star = findViewById(R.id.star)
        review = findViewById(R.id.review)

        completeButton=findViewById(R.id.complete)
        var dbHelper: DBManager = DBManager(applicationContext, "REVIEW.db", null, 1)

        //myHelper = myDBHelper(this)
        completeButton.setOnClickListener {
            var bname:String = bookName.getText().toString()
            var rstar:String = star.getText().toString()
            var rcontent:String = review.getText().toString()

            dbHelper.reviewinsert(bname, rstar, rcontent)
            Toast.makeText(applicationContext, "작성됨", Toast.LENGTH_SHORT).show()
        }



    }




}
