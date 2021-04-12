package com.example.remindme;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remindme.view.MyViewHolder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context myContext;
    private ArrayList<Content> listContent;

    public RecyclerViewAdapter(Context myContext, ArrayList<Content> listContent) {
        this.myContext = myContext;
        this.listContent = listContent;
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.item_content,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view, listContent);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getMonth().setText(listContent.get(position).getDueDate().toString().substring(4, 7));
        holder.getDay().setText(String.valueOf(listContent.get(position).getDueDate().getDate()));
        holder.getTitle().setText(listContent.get(position).getTitle());

        String temp;
        switch (listContent.get(position).getDificulty()){
            case 1:{
                temp = "Sulit";
                break;
            }
            case 2:{
                temp = "Sedang";
                break;
            }
            case 3:{
                temp = "Mudah";
                break;
            }
            default:{
                temp = " - ";
                break;
            }
        }
        holder.getDifficulty().setText("Kesulitan: " + temp);

        int remainingTime = (int) TimeUnit.DAYS.convert(
                Long.valueOf(listContent.get(position).getDueDate().getTime()) - (listContent.get(position).getDateCreated().getTime()),
                TimeUnit.MILLISECONDS);
        holder.getTimeRemaining().setText("Tersisa " + String.valueOf(remainingTime) + " hari lagi");

        updateContentColor(holder, remainingTime);
    }

    //Ubah warna recyclerview content
    public void updateContentColor(MyViewHolder holder, int remainingTime){
        if(remainingTime == 0) {
            holder.getContentCard().setBackgroundColor(Color.parseColor("#307FFF"));
        }
        else if(remainingTime < 0){
            holder.getContentCard().setBackgroundColor(Color.parseColor("#FF6A6A"));
        }
        else{
            holder.getContentCard().setBackgroundColor(Color.parseColor("#F5F9FC"));
        }
    }
}
