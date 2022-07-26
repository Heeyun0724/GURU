package com.example.guru

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

@Suppress("DEPRECATION")

class  DBManager(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            //멤버 DB 제작
            db.execSQL(
                "CREATE TABLE MEMBER(NAME TEXT," +
                        "ID TEXT, PASSWORD TEXT, PASSWORD_OK TEXT, PHONE TEXT, EMAIL TEXT, ADDRESS TEXT, LEVEL TEXT);"


            )
            //리뷰 DB 제작
            db!!.execSQL("CREATE TABLE REVIEW ( bName TEXT , rStar TEXT ,rContent TEXT);")

        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun insert(
        name: String, id: String, password: String, password_ok: String, phone: String, email: String,
        address: String, level: String
    ) {
        var db: SQLiteDatabase = writableDatabase

        db.execSQL(
            "INSERT INTO MEMBER VALUES('" + name + "'" + ", '" + id + "'" + ", '" + password + "'" + ", '" + password_ok +
                    "'" + ", '" + phone + "'" + ", '" + email + "'" + ", '" + address + "'" + ", '" + level + "');"

        )
        db.close()
    }

    fun reviewinsert(
        bname: String, rstar: String, rcontent: String
    ) {
        var db: SQLiteDatabase = writableDatabase

        db.execSQL("INSERT INTO REVIEW VALUES('" + bname + "', '" + rstar + "', '" + rcontent + "');" )
        db.close()
    }



    fun update(
        name: String, password: String, password_ok: String, phone: String, email: String,
        address: String, level: String
    ) {
        var db: SQLiteDatabase = writableDatabase

        db.execSQL(
            "UPDATE MEMBER SET PASSWORD = " + "'" + password + "'" + ", PASSWORD_OK = '" + password_ok + "'" + ", PHONE = '" + phone + "'"
                    + ", EMAIL = '" + email + "'" + ", ADDRESS = '" + address + "'" + ", LEVEL = '" + level + "'" +
                    "WHERE NAME = '" + name + "';"
        )

        db.close()
    }


    fun getResult(): String {
        var db: SQLiteDatabase = readableDatabase
        var result: String = ""

        var cursor: Cursor = db.rawQuery("SELECT * FROM MEMBER", null)
        while (cursor.moveToNext()) {
            result += (cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " : "
                    + cursor.getString(2)
                    + " : "
                    + cursor.getString(3)
                    + " : "
                    + cursor.getString(4)
                    + " : "
                    + cursor.getString(5)
                    + " : "
                    + cursor.getString(6)
                    + " : "
                    + cursor.getString(7)
                    + "\n")

        }

        return result
    }

    fun getrvResult(): String {
        var db: SQLiteDatabase = readableDatabase
        var result: String = ""

        var cursor: Cursor = db.rawQuery("SELECT * FROM REVIEW", null)
        while (cursor.moveToNext()) {
            result += ("\n[책 제목]\n"
                    + cursor.getString(0)
                    + "\n[별   점]\n"
                    + cursor.getString(1)
                    + "\n[리   뷰] \n"
                    + cursor.getString(2)
                    +"\n"
                    + "-------------------------------------")

        }

        return result
    }

    fun getResult1(ID: String, PASSWORD: String): Boolean {
        var db: SQLiteDatabase = readableDatabase
        var result: String = ""

        var cursor: Cursor = db.rawQuery("SELECT ID, PASSWORD FROM MEMBER", null)
        while (cursor.moveToNext()) {
            result = (cursor.getString(0))
            if (result.equals(ID)) {
                if (cursor.getString(1).equals(PASSWORD)) {
                    return true
                    break
                } else {
                    return false
                }
            }else {

            }
        }

        return false
    }
}
