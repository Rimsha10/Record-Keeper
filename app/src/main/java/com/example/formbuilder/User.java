package com.example.formbuilder;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity
    public class User {
        @NonNull
        @PrimaryKey (autoGenerate = true)
        public Integer uid;

        @ColumnInfo(name = "username")
        public String username;

        @ColumnInfo(name = "first_name")
        public String firstName;

        @ColumnInfo(name = "last_name")
        public String lastName;
        @ColumnInfo(name = "email")
        public String email;

        public User(Integer uid, String username, String firstName, String lastName, String email) {
            this.uid = uid;
            this.username = username;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }


        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }



    }
