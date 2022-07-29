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
     lateinit var sqlDB: SQLiteDatabase
     lateinit var myHelper: myDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_write)

        bookName = findViewById(R.id.bookname)
        star = findViewById(R.id.star)
        review = findViewById(R.id.review)

        completeButton=findViewById(R.id.complete)


        myHelper = myDBHelper(this)
        completeButton.setOnClickListener {
            var bname = bookName.text.toString()
            var rstar = star.text.toString()
            var rcontent = review.text.toString()

            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO reviewTbl VALUES('" + bname + "', '" + rstar + "', '" + rcontent + "');" )
            sqlDB.close()
            Toast.makeText(applicationContext, "작성됨", Toast.LENGTH_SHORT).show()
        }


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "reviewTbl", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE reviewTbl ( bName CHAR(100) , rStar CHAR(20) ,rContent CHAR(1000));")
        }
        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS reviewTbl")
            onCreate(db)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
