package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditStudent extends AppCompatActivity {
    EditText tv_name, tv_phoneNumber, tv_major, tv_level, tv_dOfBirth ;
    TextView tv_back, tv_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        AnhXa();

        Intent intent = getIntent();
        String name = intent.getStringExtra("keyName");
        String phoneNumber = intent.getStringExtra("keyPhoneNumber");
        String dateOfBirth = intent.getStringExtra("keyDateOfBirth");
        String level = intent.getStringExtra("keyLevel");
        String major = intent.getStringExtra("keyMajor");

        tv_name.setText(name);
        tv_phoneNumber.setText(String.valueOf(phoneNumber));
        tv_major.setText(major);
        tv_level.setText(level);
        tv_dOfBirth.setText(dateOfBirth);

        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                intent.putExtra("Name",tv_name.getText().toString());
//                intent.putExtra("PhoneNumber",tv_phoneNumber.getText().toString());
//                intent.putExtra("DateOfBirth",tv_dOfBirth.getText().toString());
//                intent.putExtra("Level",tv_level.getText().toString());
//                intent.putExtra("Major",tv_major.getText().toString());
                String name1 = tv_name.getText().toString();
                int phoneNumber1 = Integer.parseInt (tv_phoneNumber.getText().toString());
                String dateOfBirth1 = tv_dOfBirth.getText().toString();
                String level1 = tv_level.getText().toString();
                String major1 = tv_major.getText().toString();
                Students students = new Students(name1,phoneNumber1,level1,dateOfBirth1,major1);
                SQL_Helper sql_helper = new SQL_Helper(getBaseContext());
                sql_helper.UpdateStudent(name,students);
                startActivity(intent);

            }
        });


    }
    private void AnhXa(){
        tv_name = findViewById(R.id.edt_name);
        tv_phoneNumber = findViewById(R.id.edt_phoneNumber);
        tv_major = findViewById(R.id.edt_major);
        tv_level = findViewById(R.id.edt_level);
        tv_back = findViewById(R.id.tv_back);
        tv_dOfBirth = findViewById(R.id.edt_dOfBirth);
        tv_done = findViewById(R.id.tv_done);
    }
}