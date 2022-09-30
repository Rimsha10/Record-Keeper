package com.example.formbuilder;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    //query to insert a record/

    @Insert
    void insertRecord(User users);
//query to read username from User table and validate the user
     @Query("SELECT EXISTS(SELECT * FROM user where username=:username)")
     boolean UserExists(String username);

     @Query("SELECT * from user where username=:username")
     User getUser(String username);

    @Delete
    void delete(User user);

}
