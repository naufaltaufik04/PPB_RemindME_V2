package com.example.remindme.view;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remindme.Content;
import com.example.remindme.Details;
import com.example.remindme.R;

import java.util.ArrayList;

public class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView month, day, title, difficulty, timeRemaining;
    private LinearLayout contentCard;

    public MyViewHolder(@NonNull View itemView, ArrayList<Content> listContent) {
        super(itemView);

        month = itemView.findViewById(R.id.monthTextView);
        day = itemView.findViewById(R.id.dayTextView);
        title = itemView.findViewById(R.id.titleTextView);
        difficulty = itemView.findViewById(R.id.difficultyTextView);
        timeRemaining = itemView.findViewById(R.id.timeRemainingTextView);
        contentCard = itemView.findViewById(R.id.card);

        //Saat klik recyclerview item
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Details.class);
                intent.putExtra("Content", listContent.get(getAdapterPosition()));
                view.getContext().startActivities(new Intent[]{intent});
            }
        });
    }

    public TextView getMonth() {
        return month;
    }

    public void setMonth(TextView month) {
        this.month = month;
    }

    public TextView getDay() {
        return day;
    }

    public void setDay(TextView day) {
        this.day = day;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(TextView difficulty) {
        this.difficulty = difficulty;
    }

    public TextView getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(TextView timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public LinearLayout getContentCard() {
        return contentCard;
    }

    public void setContentCard(LinearLayout contentCard) {
        this.contentCard = contentCard;
    }
}