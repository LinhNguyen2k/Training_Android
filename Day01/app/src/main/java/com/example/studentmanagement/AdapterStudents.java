package com.example.studentmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class AdapterStudents extends RecyclerView.Adapter<AdapterStudents.AdapterViewHolder>{

    List<Students> studentsLists;
    Context context;

    public AdapterStudents(List<Students> studentsLists, Context context) {
        this.studentsLists = studentsLists;
        this.context = context;
    }


    @NonNull
    @NotNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_student,parent,false);

        return new AdapterViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterStudents.AdapterViewHolder holder, int position) {
        Students students = studentsLists.get(position);

        holder.tv_name.setText(students.getName());
        holder.tv_phoneNumber.setText(students.getPhoneNumber());
        holder.tv_level.setText(students.getLevel());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        holder.tv_dOfBirth.setText((String.valueOf( students.getdOfBirth())));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProFileStudent.class);
//                intent.putExtra("Name",students.getName());
//                intent.putExtra("PhoneNumber",students.getPhoneNumber());
//                intent.putExtra("DateOfBirth",students.getdOfBirth());
//                intent.putExtra("Level",students.getLevel());
                  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if(studentsLists != null){
            return studentsLists.size();
        }
        return 0;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{

        RecyclerView rc_listStudents;
        TextView tv_name, tv_phoneNumber, tv_dOfBirth, tv_level;
        public AdapterViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            rc_listStudents = itemView.findViewById(R.id.rc_listStudents);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phoneNumber = itemView.findViewById(R.id.tv_phoneNumber);
            tv_dOfBirth = itemView.findViewById(R.id.tv_dOfBirth);
            tv_level = itemView.findViewById(R.id.tv_level);
        }
    }
}
