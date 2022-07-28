package com.example.guru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ReviewWrite : AppCompatActivity() {
     lateinit var btn1: RadioButton
     lateinit var btn2: RadioButton
     lateinit var btn3: RadioButton
     lateinit var btn4: RadioButton
     lateinit var btn5: RadioButton
     lateinit var radioGroup: RadioGroup
     lateinit var complete: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_write)

         btn1 = findViewById(R.id.star_radio1)
         btn2 = findViewById(R.id.star_radio2)
         btn3  = findViewById(R.id.star_radio3)
         btn4  = findViewById(R.id.star_radio4)
         btn5  = findViewById(R.id.star_radio5)
         radioGroup = findViewById(R.id.radioGroup)
         complete = findViewById(R.id.complete)


        complete.setOnClickListener{


                Toast.makeText(this,"작성완료", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Second_Activity::class.java)
                startActivity(intent)
            }
        }
    }
