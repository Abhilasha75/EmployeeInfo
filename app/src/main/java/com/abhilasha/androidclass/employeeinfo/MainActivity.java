package com.abhilasha.androidclass.employeeinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.UpdateActivity;

public class MainActivity extends AppCompatActivity {

    EditText name,department,id,salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.et_name);
        department=findViewById(R.id.et_department);
        id=findViewById(R.id.et_id);
        salary=findViewById(R.id.et_salary);

    }

    public void SendData(View view) {

        String Name = name.getText().toString().trim();
        String Department = department.getText().toString().trim();
        String Id = id.getText().toString().trim();
        String Salary = salary.getText().toString().trim();

        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //content  values is used to put values that we want to put in the table
        ContentValues values = new ContentValues();
        values.put("name", Name);
        values.put("department", Department);
        values.put("id", Id);
        values.put("salary", Salary);

        long rowId = db.insert("employee_details", null, values);

        Log.e("Row Id", "**********" + rowId);
        Toast.makeText(this, "Data inserted Successfully"+"\n"+Name+"\n"+Department+"\n"+Id+"\n"+Salary, Toast.LENGTH_SHORT).show();


    }



    public void update(View view) {

        startActivity(new Intent(MainActivity.this, UpdateActivity.class));
    }




    public void Delete(View view) {

        startActivity(new Intent(MainActivity.this, DeleteActivity.class));
    }


    public void ShowData(View view) {

        startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
    }
}
