package com.example.studentmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SQL_Helper extends SQLiteOpenHelper {
    private static final String TAG = "SQL_Helper";

    static final String DB_NAME = "Students.db";
    static final String DB_TABLE = "SinhVien";
    static final int DB_VERSION = 1;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;


    public SQL_Helper( Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTable = "Create Table SinhVien(" +
                "phoneNumber INTEGER NOT NULL PRIMARY KEY," +
                "name TEXT,"+
                "dOfBirth TEXT,"+
                "level TEXT,"+
                "major TEXT)";

        db.execSQL(queryCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion != newVersion)
        {
            db.execSQL(" DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }
    public  void InsertStudent( Students students)
    {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("name",students.getName());
        contentValues.put("phoneNumber",students.getPhoneNumber());
        contentValues.put("dOfBirth",students.getdOfBirth());
        contentValues.put("major",students.getMajor());
        contentValues.put("level",students.getLevel());
        sqLiteDatabase.insert(DB_TABLE, null, contentValues);

    }

    public boolean UpdateStudent(String name, Students students)
    {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("name",students.getName());
        contentValues.put("phoneNumber",students.getPhoneNumber());
        contentValues.put("dOfBirth",students.getdOfBirth());
        contentValues.put("major",students.getMajor());
        contentValues.put("level",students.getLevel());

        return sqLiteDatabase.update(DB_TABLE,contentValues,"name=?",
                new String[]{String.valueOf(name)}) >=0;
    }


    public int DeleteStudent(int phoneNumber)
    {
        sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(DB_TABLE,"phoneNumber=?",new String[]{String.valueOf(phoneNumber)});

    }
    public List<Students> GetAllStudents()
    {
        List<Students> studentsLists = new ArrayList<>();
        sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String dOfBirth = cursor.getString(cursor.getColumnIndex("dOfBirth"));
            String major = cursor.getString(cursor.getColumnIndex("major"));
            String level = cursor.getString(cursor.getColumnIndex("level"));
            int phone = Integer.parseInt(cursor.getString(cursor.getColumnIndex("phoneNumber")));
            studentsLists.add( new Students(name,phone,level,dOfBirth,major));
        }
        return studentsLists;
    }


}
