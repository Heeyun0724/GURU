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
    val TAG: String = "Register"
    var isExistBlank = false
    var isPWSame = false

    lateinit var btn_register: Button
    lateinit var edit_id: EditText
    lateinit var edit_name: EditText
    lateinit var edit_email: EditText
    lateinit var edit_pw: EditText
    lateinit var edit_pw_re: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_register = findViewById(R.id.btn_register)
        edit_id = findViewById(R.id.edit_id)
        edit_email = findViewById(R.id.edit_email)
        edit_name = findViewById(R.id.edit_name)
        edit_pw = findViewById(R.id.edit_pw)
        edit_pw_re = findViewById(R.id.edit_pw_re)
        var dbManager: DBManager = DBManager(applicationContext, "MEMBER.db", null, 1)

        btn_register.setOnClickListener {
            Log.d(TAG, "회원가입 버튼 클릭")
            var id: String = edit_id.getText().toString()
            var name: String = edit_name.getText().toString()
            var email: String = edit_email.getText().toString()
            var pw: String = edit_pw.getText().toString()
            var pw_re: String = edit_pw_re.getText().toString()


            if (id.length == 0 || name.length == 0 || email.length == 0
                || pw.length == 0 || pw_re.length == 0) {
                Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
            }else {
                dbManager.insert(id, name, email, pw, pw_re)
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }



        }
    }
