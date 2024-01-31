package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MySqliteDemo extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentInformation";
    private static final String TABLE_NAME = "Student";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CLASS = "class";
    private static final String KEY_ROLL = "roll_no";
    private static final String KEY_EMAIL = "email";
    public MySqliteDemo(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      // db.execSQL("CREATE TABLE IF NOT EXISTS stud (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
       db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + KEY_NAME + "TEXT" + KEY_CLASS + " TEXT, " + KEY_ROLL + " TEXT, " + KEY_EMAIL + " TEXT )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public long insert(String name, String cls, String roll, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KEY_NAME, name);
        content.put(KEY_CLASS, cls);
        content.put(KEY_ROLL, roll);
        content.put(KEY_EMAIL, email);
        long ret =db.insert(TABLE_NAME, null, content);
        db.close();
        return ret;
    }

//    public Cursor Read()
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String qurey = "SELECT * FROM "+TABLE_NAME;
//        Cursor cur =  db.rawQuery(qurey,null);
//        db.close();
//        return cur;
//    }

//    public Boolean delete(int id)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String qurey = "SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID+"=? "+id;
//        Cursor cur =  db.rawQuery(qurey,null);
//        if(cur.moveToFirst())
//        {
//            return false;
//        }
//        else{
//            db.delete(TABLE_NAME,KEY_ID+"=?",new String[]{String.valueOf(id)});
//            db.close();
//            return true;
//        }
//    }
}
