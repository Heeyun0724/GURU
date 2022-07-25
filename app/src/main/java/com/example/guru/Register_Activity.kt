package com.example.guru

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Register_Activity : AppCompatActivity() {
    lateinit var save_Btn: Button
    lateinit var back2_Btn: Button
    lateinit var name: EditText
    lateinit var password: EditText
    lateinit var password_ok: EditText
    lateinit var id: EditText
    lateinit var email: EditText
    lateinit var address: EditText
    lateinit var level: EditText
    lateinit var phone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var dbHelper: DBManager = DBManager(applicationContext, "MEMBER.db", null, 1)

        save_Btn = findViewById(R.id.save_Btn)
        back2_Btn = findViewById(R.id.back2_Btn)
        name = findViewById(R.id.name)
        password = findViewById(R.id.password)
        password_ok = findViewById(R.id.password_ok)
        id = findViewById(R.id.id)
        email = findViewById(R.id.email)
        address = findViewById(R.id.address)
        level = findViewById(R.id.level)
        phone = findViewById(R.id.phone)


        save_Btn.setOnClickListener {
            // 회원 정보를 저장하는 부분. 데이터베이스에~
            var name: String = name.getText().toString()
            var id: String = id.getText().toString()
            var password: String = password.getText().toString()
            var password_ok: String = password_ok.getText().toString()
            var phone: String = phone.getText().toString()
            var email: String = email.getText().toString()
            var address: String = address.getText().toString()
            var level: String = level.getText().toString()

            if (name.length == 0 || id.length == 0 || password.length == 0
                || password_ok.length == 0 || phone.length == 0 || email.length == 0
                || address.length == 0 || level.length == 0
            ) {
                Toast.makeText(this,"모든 정보를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                dbHelper.insert(name, id, password, password_ok, phone, email, address, level)
                Toast.makeText(this,"회원가입을 성공하였습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        back2_Btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    }
