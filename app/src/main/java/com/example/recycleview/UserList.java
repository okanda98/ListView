package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.recycleview.Database.DBhelper;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    ListView userList;
    ArrayList dataList;
    ArrayAdapter adapter;
    DBhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userList=findViewById(R.id.User_List);
        db = new DBhelper(getApplicationContext());
        dataList=db.readAlldetails();

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,dataList);
        userList.setAdapter(adapter);

    }
}