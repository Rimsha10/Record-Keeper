package com.example.formbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FetchActivity extends AppCompatActivity {
    TextView rec_username,rec_email,rec_fname,rec_lname;
    ImageView del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetchactivity);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MSG);
        del=findViewById(R.id.imageView);
        rec_username=findViewById(R.id.f_username);
        rec_fname=findViewById(R.id.f_fname);
        rec_lname=findViewById(R.id.f_lname);
        rec_email=findViewById(R.id.f_email);
        //Bundle bundle=getIntent().getExtras();
        //String username=bundle.getString("username");
        //System.out.println(username+"0000");
        FormDatabase db = Room.databaseBuilder(getApplicationContext(), FormDatabase.class, "room_db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        UserDao userDao=db.userDao();
        User user= userDao.getUser(message);
        System.out.println(user);
        rec_username.setText(user.getUsername());
        rec_fname.setText(user.getFirstName());
        rec_lname.setText(user.getLastName());
        rec_email.setText(user.getEmail());
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDao.delete(user);
                Toast.makeText(FetchActivity.this,"Record deleted successfully",Toast.LENGTH_LONG).show();
                rec_username.setText("");
                rec_fname.setText("");
                rec_lname.setText("");
                rec_email.setText("");
                startActivity(new Intent(FetchActivity.this,MainActivity.class));
            }
        });
    }
}