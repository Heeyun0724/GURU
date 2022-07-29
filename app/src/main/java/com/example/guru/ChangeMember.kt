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
    lateinit var editText0: EditText
    lateinit var save_Btn: Button
    lateinit var cancel_Btn: Button

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
        editText0 = findViewById(R.id.editText0)
        save_Btn = findViewById(R.id.save_Btn)
        cancel_Btn = findViewById(R.id.cancel_Btn)

        var dbHelper: DBManager = DBManager(applicationContext, "MEMBER.db", null, 1)


        ok_Btn.setOnClickListener {
            // editText에 입력된 이름을 가져와 update를 수행한다.
            // editText에 입력된 이름이 저장된 회원과 동일한 이름을 가져야만 동작해야 한다.
            // 존재하지 않는다면 toast 메세지를 출력하여 존재하지 않는 이름이라는 것을 알려준다.

            if (dbHelper.getResult2(editText3.getText().toString()) == true) {

                editText0.visibility = View.VISIBLE
                editText4.visibility = View.VISIBLE
                editText5.visibility = View.VISIBLE
                editText6.visibility = View.VISIBLE
                editText7.visibility = View.VISIBLE
                editText8.visibility = View.VISIBLE
                editText9.visibility = View.VISIBLE

                save_Btn.visibility = View.VISIBLE
                cancel_Btn.visibility = View.VISIBLE

            } else {
                Toast.makeText(this, "존재하지 않는 이름입니다.", Toast.LENGTH_SHORT).show()
            }

            save_Btn.setOnClickListener {
                // update문을 수행한다.
                var name: String = editText3.getText().toString()
                var password: String = editText4.getText().toString()
                var password_ok: String = editText5.getText().toString()
                var phone: String = editText6.getText().toString()
                var email: String = editText7.getText().toString()
                var address: String = editText8.getText().toString()
                var level: String = editText9.getText().toString()
                var id: String = editText0.getText().toString()

                dbHelper.update(name, id, password, password_ok, phone, email, address, level)

                Toast.makeText(this, "회원정보를 수정하였습니다.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Second_Activity::class.java)
                startActivity(intent)

            }


            cancel_Btn.setOnClickListener {
                val intent = Intent(this, Second_Activity::class.java)
                startActivity(intent)
            }
        }
    }
}