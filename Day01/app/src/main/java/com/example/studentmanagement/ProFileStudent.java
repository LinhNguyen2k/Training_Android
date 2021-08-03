package com.example.studentmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.studentmanagement.model.Students;

public class ProFileStudent extends AppCompatActivity {

    TextView tv_name, tv_phoneNumber, tv_major, tv_level, tv_back, tv_dOfBirth, tv_edit;
    Students students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_file_student);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        AnhXa();
        Intent intent = getIntent();
        students = intent.getParcelableExtra("object");
//        String name = intent.getStringExtra("Name");
//        int phoneNumber = intent.getIntExtra("PhoneNumber",1);
//        String dateOfBirth = intent.getStringExtra("DateOfBirth");
//        String level = intent.getStringExtra("Level");
//        String major = intent.getStringExtra("Major");

        tv_name.setText(students.getName());
        tv_phoneNumber.setText(String.valueOf(students.getPhoneNumber()));
        tv_major.setText(students.getMajor());
        tv_level.setText(students.getLevel());
        tv_dOfBirth.setText(students.getdOfBirth());


        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(),EditStudent.class);
                intent1.putExtra("keyName",tv_name.getText().toString());
                intent1.putExtra("keyPhoneNumber",tv_phoneNumber.getText().toString());
                intent1.putExtra("keyDateOfBirth",tv_dOfBirth.getText().toString());
                intent1.putExtra("keyMajor",tv_major.getText().toString());
                intent1.putExtra("keyLevel",tv_level.getText().toString());

                startActivity(intent1);
            }
        });

    }
    private void AnhXa(){
        tv_name = findViewById(R.id.tv_name);
        tv_phoneNumber = findViewById(R.id.tv_phoneNumber);
        tv_major = findViewById(R.id.tv_major);
        tv_level = findViewById(R.id.tv_level);
        tv_back = findViewById(R.id.tv_back);
        tv_dOfBirth = findViewById(R.id.tv_dOfBirth);
        tv_edit = findViewById(R.id.tv_edit);
    }
}