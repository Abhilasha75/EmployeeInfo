package com.abhilasha.androidclass.employeeinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        id = findViewById(R.id.d_id);

    }

    public void Delete(View view) {

        String Id = id.getText().toString().trim();

        DbHelper db=new DbHelper(this);

        boolean delete= db.deleteData(Id);
        if(delete)
        {
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}