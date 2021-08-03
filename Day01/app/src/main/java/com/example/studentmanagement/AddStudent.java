package com.example.studentmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddStudent extends AppCompatActivity {
    EditText tv_name, tv_phoneNumber, tv_major, tv_level, tv_dOfBirth;
    TextView tv_back, tv_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        AnhXa();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Name",tv_name.getText().toString());
                intent.putExtra("PhoneNumber",tv_phoneNumber.getText().toString());
                intent.putExtra("Major",tv_major.getText().toString());
                intent.putExtra("Level",tv_level.getText().toString());
                intent.putExtra("DateOfBirth",tv_dOfBirth.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
    private void AnhXa(){
        tv_name = findViewById(R.id.edt_name);
        tv_phoneNumber = findViewById(R.id.edt_phoneNumber);
        tv_major = findViewById(R.id.edt_edt_major);
        tv_level = findViewById(R.id.edt_level);
        tv_back = findViewById(R.id.tv_back);
        tv_dOfBirth = findViewById(R.id.edt_dOfBirth);
        tv_done = findViewById(R.id.tv_done);
    }
}