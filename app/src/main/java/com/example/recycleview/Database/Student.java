package com.example.recycleview.Database;

import android.provider.BaseColumns;

public final class Student{
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    public Student() {}

    /* Inner class that defines the table contents */
    public static class Students implements BaseColumns {
        public static final String TABLE_NAME = "Student_Table";
        public static final String COLUMN_1 = "name";
        public static final String COLUMN_2 = "school";
        public static final String COLUMN_3 = "age";
        public static final String COLUMN_4 = "address";
    }
}