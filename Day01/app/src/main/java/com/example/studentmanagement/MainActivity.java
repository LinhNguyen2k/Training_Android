package com.example.studentmanagement;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.studentmanagement.adapter.AdapterStudents;
import com.example.studentmanagement.model.Students;
import com.example.studentmanagement.sql.SQL_Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img_addStudent;
    EditText edt_searchStudent;
    Button btn_sortByName, btn_sortByDBO,btn_sortByPhoneNumber, btn_findByUniversity, btn_findByCollege;
    RecyclerView rc_listStudents;
    List<Students> studentsLists;
    AdapterStudents adapterStudents;
    Students students;
    int mPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        AnhXa();
        SQL_Helper sql_helper = new SQL_Helper(this);
        studentsLists = sql_helper.GetAllStudents();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rc_listStudents.setHasFixedSize(true);
        rc_listStudents.setLayoutManager(linearLayoutManager);
        adapterStudents= new AdapterStudents(studentsLists, getBaseContext());
        rc_listStudents.setAdapter(adapterStudents);

        adapterStudents.setOnclickStudents(new setOnclickStudents() {
            @Override
            public void onClickItem(Students students) {
                mPosition = studentsLists.indexOf(students);
//                Toast.makeText(getBaseContext(),"Hello",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,ProFileStudent.class);
                intent.putExtra("object", (Parcelable) studentsLists.get(mPosition));
                startActivity(intent);
            }
        });

        img_addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),AddStudent.class);
                startActivityForResult(intent,2);
            }
        });

        edt_searchStudent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });

        btn_sortByName.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SortByName();
            }
        });
        btn_sortByDBO.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SortByDBO();
            }
        });
        btn_sortByPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SortByDPhoneNumber();
            }
        });
        btn_findByCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterByLevel("Cao Đẳng");
            }
        });
        btn_findByUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterByLevel("Đại Học");
            }
        });
    }

    private void filter(String text) {
        ArrayList<Students> filter = new ArrayList<>();
        for(Students item : studentsLists)
        {
            if(item.getName().toLowerCase().contains(text.toLowerCase()))
                filter.add(item);
        }
        adapterStudents.filterList(filter);
    }

    public void AnhXa(){
        img_addStudent = findViewById(R.id.img_addStudent);
        edt_searchStudent = findViewById(R.id.edt_searchStudent);
        btn_sortByName = findViewById(R.id.btn_sortByName);
        btn_sortByDBO = findViewById(R.id.btn_sortByDBO);
        btn_sortByPhoneNumber = findViewById(R.id.btn_sortByPhoneNumber);
        rc_listStudents = findViewById(R.id.rc_listStudents);
        btn_findByUniversity = findViewById(R.id.btn_findByUniversity);
        btn_findByCollege = findViewById(R.id.btn_findByCollege);
    }
//    private List<Students> AddStudens(){
//        List<Students> list = new ArrayList<>();
//
//        list.add(new Students("Nguyễn Anh Linh",815619200,"Đại Học","27/09/2000","CNTT"));
//        list.add(new Students("Nguyễn Anh Linh",815619200,"Đại Học","2000/09/27","HTTT"));
//        list.add(new Students("Nguyễn Anh Linh",815619200,"Đại Học","2000/09/27","CNTT"));
//        list.add(new Students("Nguyễn Anh Linh",815619200,"Đại Học","2000/09/27","KHMT"));
//        list.add(new Students("Nguyễn Anh Linh",815619200,"Đại Học","2000/09/27","KTPM"));
//
//        return list;
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {

            case RESULT_OK:
                String name = data.getStringExtra("Name");
                int phoneNumber = Integer.parseInt (data.getStringExtra("PhoneNumber"));
                String dateOfBirth = data.getStringExtra("DateOfBirth");
                String level = data.getStringExtra("Level");
                String major = data.getStringExtra("Major");

                    studentsLists.add(new Students(name,phoneNumber,level,dateOfBirth,major));
                    adapterStudents.notifyDataSetChanged();
                    SQL_Helper sql_helper = new SQL_Helper(this);
                    sql_helper.InsertStudent(new Students(name,phoneNumber,level,dateOfBirth,major));
                    SetLayout(studentsLists);
                break;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SortByName(){
        List<Students> list = new ArrayList<>();
        SQL_Helper sql_helper = new SQL_Helper(this);
        list = sql_helper.GetAllStudents();
        Collections.sort(list, (sv1, sv2) -> sv1.getName().compareTo(sv2.getName()));
        SetLayout(list);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SortByDBO(){
        List<Students> list = new ArrayList<>();
        SQL_Helper sql_helper = new SQL_Helper(this);
        list = sql_helper.GetAllStudents();

        Collections.sort(list, (sv1, sv2) -> sv2.getdOfBirth().compareTo(sv1.getdOfBirth()));
        SetLayout(list);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SortByDPhoneNumber(){
        List<Students> list = new ArrayList<>();
        SQL_Helper sql_helper = new SQL_Helper(this);
        list = sql_helper.GetAllStudents();
        Collections.sort(list, new Comparator<Students>() {

            @Override
            public int compare(Students sv1, Students sv2) {
                return sv1.getPhoneNumber() - sv2.getPhoneNumber();
            }
        });
        SetLayout(list);
    }
    public void SetLayout(List<Students> list){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rc_listStudents.setHasFixedSize(true);
        rc_listStudents.setLayoutManager(linearLayoutManager);
       // rc_listStudents.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        adapterStudents= new AdapterStudents(list, getBaseContext());
        rc_listStudents.setAdapter(adapterStudents);
    }

    public void  filterByLevel(String level) {
        List<Students> list = new ArrayList<>();
        if (level.contains("Cao Đẳng")) {
            for (Students students : studentsLists) {
                if (students.getLevel().contains("Cao Đẳng")) {
                    list.add(students);
                }
            }
        } else {
            for (Students student : studentsLists) {
                if (student.getLevel().contains("Đại Học")) {
                    list.add(student);
                }
            }
        }
        SetLayout(list);
    }

}