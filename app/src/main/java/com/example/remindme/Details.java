package com.example.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    private Content content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Sembuyikan header/toolbar
        getSupportActionBar().hide();

        Intent intent = getIntent();
        content = intent.getParcelableExtra("Content");

        OnBackButtonClickListener();
        setCardContent();
    }

    private void OnBackButtonClickListener(){
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setCardContent(){
        TextView title = findViewById(R.id.titleInput);
        TextView details = findViewById(R.id.detailsInput);
        TextView difficulty = findViewById(R.id.difficultyInput);
        TextView dueDate = findViewById(R.id.dueDateInput);

        title.setText(content.getTitle());
        details.setText(content.getDetails());

        String temp;
        switch (content.getDificulty()){
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
        difficulty.setText(temp);

        dueDate.setText(content.getDueDate().getDate() +
                " - " + (content.getDueDate().getMonth()+1) +
                " - " + (content.getDueDate().getYear()+1900));
    }
}