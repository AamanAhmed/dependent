package com.example.test4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Db extends SQLiteOpenHelper {

    String Databasename = "employee.db";
    public Db(@Nullable Context context) { super (context, "employee.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table depart(Id integer primary key autoincrement,deptname text, employeeno integer)");
        sqLiteDatabase.execSQL("create table emp(Id integer primary key autoincrement,name text,deptid integer,salary integer)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists depart");
        sqLiteDatabase.execSQL("drop table if exists emp");

    }

    public  void deptinsert (String deptname , int empno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("deptname", deptname);
        c.put("employeeno", empno);
        db.insert("depart", null, c);
    }

    public  void employeeinsert (String empname, Integer deptid, Integer empsalary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name", empname);
        c.put("deptid", deptid);
        c.put("salary", empsalary);
//        c.put("gender", gender);
        db.insert("emp", null, c);
    }

    public List<String> fetchdata (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("Select * from depart" , null);
        List<String> tablerecord = new ArrayList<>();
        while (find.moveToNext()){
            tablerecord.add(find.getString(1));
        }
        return tablerecord;
    }


    public List<String> fetch2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("Select * from emp" , null);
        List<String> tablerecord = new ArrayList<>();
        while (find.moveToNext()){
            tablerecord.add(find.getString(1));
        }
        return tablerecord;
    }

    public ArrayList<HashMap<String,String>> fetchdata2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select name from emp",null);
        // Table
        ArrayList<HashMap<String,String>> records = new ArrayList<>();
        while (find.moveToNext()){
            // Column
            HashMap<String,String> column = new HashMap<>();
            column.put("Name",find.getString(0));

            records.add(column);
        }
        return records;

    }
}
