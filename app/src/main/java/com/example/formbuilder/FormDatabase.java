package com.example.formbuilder;

import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {User.class}, version = 4)
    //extend RoomDatabase/
    public abstract class FormDatabase extends RoomDatabase {
        public abstract UserDao userDao();
        //Create interface object/
    }
