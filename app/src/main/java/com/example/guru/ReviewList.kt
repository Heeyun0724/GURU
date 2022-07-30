package com.example.guru

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView


class ReviewList : AppCompatActivity() {

    lateinit var rv_list: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_list)
        rv_list = findViewById(R.id.rv_list)

        //텍스트뷰 스크롤 가능하게 하는 코드
        rv_list.movementMethod = ScrollingMovementMethod.getInstance()

        var dbHelper: DBManager = DBManager(applicationContext, "REVIEW.db", null, 1)

        rv_list.setText(dbHelper.getrvResult())
    }

    //액션바 뒤로가기 코드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
