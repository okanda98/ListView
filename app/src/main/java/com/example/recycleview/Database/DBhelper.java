package com.example.recycleview.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +   Student.Students.TABLE_NAME + " (" +
                    Student.Students._ID + " INTEGER PRIMARY KEY," +
                    Student.Students.COLUMN_1+ " TEXT," +
                    Student.Students.COLUMN_2+ " TEXT," +
                    Student.Students.COLUMN_3+ " TEXT," +
                    Student.Students.COLUMN_4 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Student.Students.TABLE_NAME;

    public long addInfo(String name,String school,String age,String address){
// Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Student.Students.COLUMN_1,name);
        values.put(Student.Students.COLUMN_2, school);
        values.put(Student.Students.COLUMN_3, age);
        values.put(Student.Students.COLUMN_4, address);


// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Student.Students.TABLE_NAME, null, values);
        return newRowId;

    }
    public ArrayList readAlldetails() {
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Student.Students.COLUMN_1,
                Student.Students.COLUMN_2,
                Student.Students.COLUMN_3,
                Student.Students.COLUMN_4,
        };

        // Filter results WHERE "title" = 'My Title'
        //String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        //String[] selectionArgs = {"My Title"};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                        Student.Students.COLUMN_1 + " DESC";

        Cursor cursor = db.query(
                Student.Students.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        ArrayList UserInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String name= cursor.getString(cursor.getColumnIndexOrThrow(Student.Students.COLUMN_1));
            String school= cursor.getString(cursor.getColumnIndexOrThrow(Student.Students.COLUMN_2));
            String age= cursor.getString(cursor.getColumnIndexOrThrow(Student.Students.COLUMN_3));
            String address= cursor.getString(cursor.getColumnIndexOrThrow(Student.Students.COLUMN_4));
            UserInfo.add(name);
            UserInfo.add(school);
            UserInfo.add(age);
            UserInfo.add(address);
        }
        cursor.close();
        return UserInfo;
    }

}
