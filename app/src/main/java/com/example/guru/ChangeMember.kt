package com.example.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ChangeMember : AppCompatActivity() {
    lateinit var ok_Btn: Button
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var editText5: EditText
    lateinit var editText6: EditText
    lateinit var editText7: EditText
    lateinit var editText8: EditText
    lateinit var editText9: EditText
    lateinit var button2: Button
    lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_member)
        ok_Btn = findViewById(R.id.ok_Btn)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)
        editText5 = findViewById(R.id.editText5)
        editText6 = findViewById(R.id.editText6)
        editText7 = findViewById(R.id.editText7)
        editText8 = findViewById(R.id.editText8)
        editText9 = findViewById(R.id.editText9)
        button2= findViewById(R.id.button2)
        button3= findViewById(R.id.button3)

        var dbHelper: DBManager = DBManager(applicationContext, "MEMBER.db", null, 1)


        ok_Btn.setOnClickListener {
            // editText에 입력된 이름을 가져와 update를 수행한다.
            editText4.visibility = View.VISIBLE
            editText5.visibility = View.VISIBLE
            editText6.visibility = View.VISIBLE
            editText7.visibility = View.VISIBLE
            editText8.visibility = View.VISIBLE
            editText9.visibility = View.VISIBLE

            button2.visibility = View.VISIBLE
            button3.visibility = View.VISIBLE

        }

        button2.setOnClickListener{
            // update문을 수행한다.
            var name : String = editText3.getText().toString()
            var password : String = editText4.getText().toString()
            var password_ok : String = editText5.getText().toString()
            var phone : String = editText6.getText().toString()
            var email : String = editText7.getText().toString()
            var address : String = editText8.getText().toString()
            var level : String = editText9.getText().toString()

            dbHelper.update(name, password, password_ok, phone, email, address, level)

            Toast.makeText(this,"회원정보를 수정하였습니다.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Second_Activity::class.java)
            startActivity(intent)

        }


        button3.setOnClickListener {
            val intent = Intent(this, Second_Activity::class.java)
            startActivity(intent)
        }
    }
}