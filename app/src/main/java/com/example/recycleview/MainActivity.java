package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycleview.Database.DBhelper;
import com.example.recycleview.Database.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,school,age,address;
    Button add ,view;
    private List <Student> StudentList  =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name=findViewById(R.id.t1);
        school=findViewById(R.id.t2);
        age =findViewById(R.id.t3);
        address=findViewById(R.id.t4);
        add=findViewById(R.id.b1);
        view=findViewById(R.id.b2);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBhelper dbHelper = new DBhelper(getApplicationContext());
              dbHelper.addInfo(name.getText().toString(),school.getText().toString(),age.getText().toString(),address.getText().toString());
          //     StudentList.add(Student1);
                Toast.makeText(MainActivity.this, "Success full added ", Toast.LENGTH_SHORT).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DBhelper dbHelper = new DBhelper(getApplicationContext());
                Intent i= new Intent(getApplicationContext(),UserList.class);
                startActivity(i);
            }
        });
    }
}