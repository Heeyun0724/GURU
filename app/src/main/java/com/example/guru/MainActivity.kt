package com.example.guru

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    lateinit var btn_login: Button
    lateinit var btn_register: Button
    lateinit var edit_id: EditText
    lateinit var edit_pw: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_register = findViewById(R.id.btn_register)
        btn_login = findViewById(R.id.btn_login)
        edit_id = findViewById(R.id.edit_id)
        edit_pw = findViewById(R.id.edit_pw)

        var dbManager: DBManager = DBManager(applicationContext, "MEMBER.db", null, 1)

        btn_login.setOnClickListener {
            if(dbManager.getResult1(edit_id.getText().toString(), edit_pw.getText().toString()) == true){
                Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Second_Activity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        // 회원가입 버튼
        btn_register.setOnClickListener {
            val intent = Intent(this, Register_Activity::class.java)
            startActivity(intent)
        }

    }



}
