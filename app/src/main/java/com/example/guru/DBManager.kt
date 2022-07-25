package com.example.guru

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

@Suppress("DEPRECATION")
class DBManager(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(
                "CREATE TABLE MEMBER(name text, email text, id INTEGER, pw text, pw_re text)"
            )

        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(
        name: String,
        id: String,
        pw: String,
        pw_re: String,
        email: String

    ) {
        var db: SQLiteDatabase = writableDatabase

        db.execSQL(
            "INSERT INTO MEMBER VALUES ('"+id+"', '"+name+"', "+email+", '" +pw+"','"+pw_re+"');")


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
                    + "\n")

        }

        return result
    }

    fun getResult1(ID: String, PW: String): Boolean {
        var db: SQLiteDatabase = readableDatabase
        var result: String = ""

        var cursor: Cursor = db.rawQuery("SELECT ID, PW FROM MEMBER", null)
        while (cursor.moveToNext()) {
            result = (cursor.getString(0))
            if (result.equals(ID)) {
                if (cursor.getString(1).equals(PW)) {
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
