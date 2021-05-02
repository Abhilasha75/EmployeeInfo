package com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.abhilasha.androidclass.employeeinfo.DbHelper;
import com.abhilasha.androidclass.employeeinfo.MainActivity;
import com.abhilasha.androidclass.employeeinfo.R;
import com.abhilasha.androidclass.employeeinfo.RecyclerViewActivity;
import com.abhilasha.androidclass.employeeinfo.RecyclerViewAdapter;
import com.abhilasha.androidclass.employeeinfo.model;

import java.util.ArrayList;

import static com.abhilasha.androidclass.employeeinfo.R.*;

public class UpdateActivity extends AppCompatActivity {



    EditText name, department, id, salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_update);


        name = findViewById(R.id.u_name);
        department = findViewById(R.id.u_department);
        id = findViewById(R.id.u_id);
        salary = findViewById(R.id.u_salary);
    }


    public void update(View view) {
        String Name = name.getText().toString().trim();
        String Department = department.getText().toString().trim();
        String Id = id.getText().toString().trim();
        String Salary = salary.getText().toString().trim();

        DbHelper db=new DbHelper(this);

       // ContentValues values=new ContentValues();


       boolean updateData= db.isUpdate(Name,Department,Id,Salary);
       if(updateData) {

           Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
       }
       else{
           Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();
       }



    }


}
