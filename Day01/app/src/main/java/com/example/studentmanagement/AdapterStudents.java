package com.example.studentmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdapterStudents extends RecyclerView.Adapter<AdapterStudents.AdapterViewHolder>{

    List<Students> studentsLists;
    Context context;
    int mPosotiom;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

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
        if(students ==null){
            return;
        }

        holder.tv_name.setText(students.getName());
        holder.tv_phoneNumber.setText(String.valueOf(students.getPhoneNumber()));
        holder.tv_level.setText(students.getLevel());
        holder.tv_major.setText(students.getMajor());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        holder.tv_dOfBirth.setText((String.valueOf( students.getdOfBirth())));

        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(students.getPhoneNumber()));
        holder.linearLayoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentsLists.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                SQL_Helper sql_helper = new SQL_Helper(context);
                sql_helper.DeleteStudent(students.getPhoneNumber());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProFileStudent.class);
                intent.putExtra("Name",students.getName());
                intent.putExtra("PhoneNumber",students.getPhoneNumber());
                intent.putExtra("DateOfBirth",students.getdOfBirth());
                intent.putExtra("Major",students.getMajor());
                intent.putExtra("Level",students.getLevel());
                mPosotiom = position;
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
        private SwipeRevealLayout swipeRevealLayout;
        LinearLayout linearLayoutDelete;
        RecyclerView rc_listStudents;
        TextView tv_name, tv_phoneNumber, tv_dOfBirth, tv_level, tv_major;
        public AdapterViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            rc_listStudents = itemView.findViewById(R.id.rc_listStudents);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phoneNumber = itemView.findViewById(R.id.tv_phoneNumber);
            tv_dOfBirth = itemView.findViewById(R.id.tv_dOfBirth);
            tv_level = itemView.findViewById(R.id.tv_level);
            tv_major = itemView.findViewById(R.id.tv_major);
            swipeRevealLayout = itemView.findViewById(R.id.swipeRevealLayout);
            linearLayoutDelete = itemView.findViewById(R.id.layoutDelete);
        }
    }
    public void filterList(ArrayList<Students> filter)
    {
        studentsLists = filter;
        notifyDataSetChanged();
    }
}
