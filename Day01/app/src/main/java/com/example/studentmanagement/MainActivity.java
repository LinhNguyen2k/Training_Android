package com.example.studentmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img_addStudent;
    EditText edt_searchStudent;
    Button btn_sortByName, btn_sortByDBO,btn_sortByPhoneNumber;
    RecyclerView rc_listStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        AnhXa();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rc_listStudents.setHasFixedSize(true);
        rc_listStudents.setLayoutManager(linearLayoutManager);
        rc_listStudents.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        AdapterStudents  adapterStudents= new AdapterStudents(AddStudens(), getBaseContext());
        rc_listStudents.setAdapter(adapterStudents);

        img_addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddStudent.class);
                startActivity(intent);
            }
        });

    }

    public void AnhXa(){
        img_addStudent = findViewById(R.id.img_addStudent);
        edt_searchStudent = findViewById(R.id.edt_searchStudent);
        btn_sortByName = findViewById(R.id.btn_sortByName);
        btn_sortByDBO = findViewById(R.id.btn_sortByDBO);
        btn_sortByPhoneNumber = findViewById(R.id.btn_sortByPhoneNumber);
        rc_listStudents = findViewById(R.id.rc_listStudents);
    }
    private List<Students> AddStudens(){
        List<Students> list = new ArrayList<>();

        list.add(new Students("Nguyễn Anh Linh","0815619200","Đại Học","27/09/2000"));
        list.add(new Students("Nguyễn Anh Linh","0815619200","Đại Học","2000/09/27"));
        list.add(new Students("Nguyễn Anh Linh","0815619200","Đại Học","2000/09/27"));
        list.add(new Students("Nguyễn Anh Linh","0815619200","Đại Học","2000/09/27"));
        list.add(new Students("Nguyễn Anh Linh","0815619200","Đại Học","2000/09/27"));

        return list;
    }
}