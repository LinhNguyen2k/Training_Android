package com.example.week03

import android.R.attr
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception
import android.R.attr.password
import com.example.week03.model.User
import com.example.week03.model.Users


class SQLite_Account(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        const val DB_NAME = "Account_List.db"
        const val DB_TABLE_LOGIN = "registration"
        const val DB_VERSION = 1
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE registration(ID INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT,password TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + DB_TABLE_LOGIN)
            onCreate(db)
        }
    }

    fun addUser(
        email: String?,
        password: String?,
    ): Long {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put("email", email)
        contentValues.put("password", password)
        return db.insert("registration", null, contentValues)
    }

    fun chekUser(email: String?, password: String?): Boolean {
        val db = this.writableDatabase
        val Query =
            "select * from registration where email='$email' and password='$password'"
        var cursor: Cursor? = null
        try {
            cursor =
                db.rawQuery(Query, null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return if (cursor != null && cursor.count > 0) {
            cursor.close()
            true
        } else {
            cursor!!.close()
            false
        }
    }
    fun checkEmail(email: String): Boolean {
        var list = GetallUser()
        if (list != null) {
            for (item in list) {
                if (item.email.equals(email))
                    return false
            }
        }
        return true
    }
    fun updateData(email: String, password: String):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("email", email)
        contentValues.put("password", password)
        db.update(DB_TABLE_LOGIN, contentValues, "email = ?", arrayOf(email))
        return true
    }
//    fun updateUser(email: String?, password: String?): Boolean {
//        val db = writableDatabase
//        val contentValues = ContentValues()
//        contentValues.put("email", email)
//        contentValues.put("password", password)
//
//        return db.update("registration",contentValues,"name=?",
//            arrayOf(email.toString())
//        ) >= 0
//    }

//    fun getallUser(): ArrayList<User> {
//        var arrayList: ArrayList<User> = ArrayList()
//        val db = this.writableDatabase
//        val cursor: Cursor?
//        try {
//            cursor = db.rawQuery("select * from registration", null)
//        } catch (e: Exception) {
//            return ArrayList()
//        }
//        if(cursor.moveToFirst())
//        {
//            do {
//                val user = User(cursor.getString(0).toString(),cursor.getString(1).toString())
//                arrayList.add(user)
//            }while (cursor.moveToNext())
//        }
//        return arrayList
//    }

    fun GetallUser(): List<User>? {
        val user: ArrayList<User> = ArrayList<User>()
        val db = this.writableDatabase
        val cursor: Cursor = db.query(
            false, DB_TABLE_LOGIN,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
        while (cursor.moveToNext()) {
            val email = cursor.getString(cursor.getColumnIndex("email"))
            val password = cursor.getString(cursor.getColumnIndex("password"))
            user.add(User(email, password))
        }
        return user
    }

}