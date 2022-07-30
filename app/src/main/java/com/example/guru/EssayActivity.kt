package com.example.guru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class EssayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_essay_page)
        //액션바 뒤로가기 추가
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    //뒤로가기 코드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}