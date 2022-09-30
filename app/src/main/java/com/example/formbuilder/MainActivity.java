package com.example.formbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.com.example.formbuilder";
    private EditText user_name,fname,lname, f_email;
    private Button submit_btn;
    private String firstname,lastname,username,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname=findViewById(R.id.f_Name);
        lname=findViewById(R.id.l_Name);
        f_email=findViewById(R.id.email);
        user_name=findViewById(R.id.User_Name);
        submit_btn=findViewById(R.id.button);

        //Bundle bundle=new Bundle();
        //bundle.putString("username", user_name.getText().toString());

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FormDatabase db = Room.databaseBuilder(getApplicationContext(),
                        FormDatabase.class, "room_db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
                UserDao userDao = db.userDao();
                if (user_name.getText().toString().isEmpty()){
                    user_name.setError("Required field");
                }
                else if (fname.getText().toString().isEmpty()){
                    fname.setError("Required field");
                }
                else if(lname.getText().toString().isEmpty()){
                    lname.setError("Required field");
                }
                else if (f_email.getText().toString().isEmpty()){
                    f_email.setError("Required field");
                }
                else if (userDao.UserExists(user_name.getText().toString())){
                    Toast.makeText(MainActivity.this,"Username already exists. Please try with another username",Toast.LENGTH_LONG).show();

                }
                else{
                    userDao.insertRecord(new User(null,user_name.getText().toString(),fname.getText().toString(),lname.getText().toString(),f_email.getText().toString()));

                    Toast.makeText(MainActivity.this,"Data submitted successfully!",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(MainActivity.this,FetchActivity.class);
                    intent.putExtra(MSG,user_name.getText().toString());
                    startActivity(intent);
                }

            }
        });

    }

}