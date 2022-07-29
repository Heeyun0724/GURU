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

        //테이블 생성
        myHelper = myDBHelper(this)
        //작성 완료 버튼 클릭시 동작 수행 코드
        completeButton.setOnClickListener {
            var bname = bookName.text.toString()
            var rstar = star.text.toString()
            var rcontent = review.text.toString()

            //reviewTbl에 리뷰 데이터 저장(삽입)
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO reviewTbl VALUES('" + bname + "', '" + rstar + "', '" + rcontent + "');" )
            sqlDB.close()
            Toast.makeText(applicationContext, "작성됨", Toast.LENGTH_SHORT).show()
        }


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "reviewTbl", null, 1) {
        //reviewTbl 테이블 생성
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE reviewTbl ( bName CHAR(100) , rStar CHAR(20) ,rContent CHAR(1000));")
        }
        //reviewTbl이 존재 시 테이블 삭제
        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS reviewTbl")
            onCreate(db)
        }
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
