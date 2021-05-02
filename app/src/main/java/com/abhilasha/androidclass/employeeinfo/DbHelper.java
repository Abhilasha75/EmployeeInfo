package com.abhilasha.androidclass.employeeinfo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.UpdateActivity;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";
    public static final int DATABASE_VERSION= 5;
    public static final String CREATE_TABLE="CREATE TABLE employee_details(name text,department text,id text,salary text)";

    public DbHelper( RecyclerViewActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DbHelper(@Nullable MainActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DbHelper(UpdateActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DbHelper(DeleteActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isUpdate(String name,String department,String id ,String salary )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("name", name);
        values.put("department", department);
        //values.put("id", "id");
        values.put("salary", salary);

        db.update("employee_details",values,"id=?", new String[]{String.valueOf(id)});

        return true;

    }

    public boolean deleteData(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("employee_details","id=?",new String[]{String.valueOf(id)});
        return true;
    }
}
