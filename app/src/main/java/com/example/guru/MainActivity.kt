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
    lateinit var login_Btn: Button
    lateinit var register_Btn: Button
    lateinit var editText: EditText
    lateinit var editText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login_Btn = findViewById(R.id.login_Btn)
        register_Btn = findViewById(R.id.register_Btn)
        editText = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)
        var dbHelper: DBManager = DBManager(applicationContext, "MEMBER.db", null, 1)

        login_Btn.setOnClickListener {
            if(dbHelper.getResult1(editText.getText().toString(), editText2.getText().toString()) == true){
                Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Second_Activity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        register_Btn.setOnClickListener {
            val intent = Intent(this, Register_Activity::class.java)
            startActivity(intent)
        }

    }



}
