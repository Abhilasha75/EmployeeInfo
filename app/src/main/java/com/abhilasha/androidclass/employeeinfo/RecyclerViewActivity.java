package com.abhilasha.androidclass.employeeinfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rv_data;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<model> modelArrayList;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_layout);

        rv_data=(RecyclerView) findViewById(R.id.rv_data);
        modelArrayList=new ArrayList<model>();
        rv_data.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter=new RecyclerViewAdapter(modelArrayList,this);





        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String[] cols={"name","department","id","salary"};


        Cursor cursor=db.query("Employee_details",cols,"",null,"","","","");

        while (cursor.moveToNext())
        {
            String e_name=cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String e_depart=cursor.getString(cursor.getColumnIndexOrThrow("department"));
            String e_id=cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String e_salary=cursor.getString(cursor.getColumnIndexOrThrow("salary"));


            model model=new model(""+e_name,""+e_depart,""+e_id,""+e_salary);
            modelArrayList.add(model);


        }



        cursor.close();

        rv_data.setAdapter(recyclerViewAdapter);

    }
}
