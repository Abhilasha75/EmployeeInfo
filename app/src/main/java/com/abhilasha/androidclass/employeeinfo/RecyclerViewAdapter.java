package com.abhilasha.androidclass.employeeinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder>{

    ArrayList<model> list;
    Context context;

    public RecyclerViewAdapter(ArrayList<model> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.department.setText(list.get(position).getDepart());
        holder.id.setText(list.get(position).getId());
        holder.salary.setText(list.get(position).getSalary());


    }

    @Override

    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView name,department,id,salary;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.cs_name);
            department = itemView.findViewById(R.id.cs_depart);
            id = itemView.findViewById(R.id.cs_id);
            salary = itemView.findViewById(R.id.cs_salary);

        }
    }

}
