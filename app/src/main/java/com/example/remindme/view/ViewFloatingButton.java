package com.example.remindme.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewFloatingButton {
    private FloatingActionButton byDifficultyButton;
    private FloatingActionButton byDateButton;
    private FloatingActionButton byCreatedButton;
    private Animation fromBottom;
    private Animation toBottom;

    public FloatingActionButton getByDifficultyButton() {
        return byDifficultyButton;
    }

    public void setByDifficultyButton(FloatingActionButton byDifficultyButton) {
        this.byDifficultyButton = byDifficultyButton;
    }

    public FloatingActionButton getByDateButton() {
        return byDateButton;
    }

    public void setByDateButton(FloatingActionButton byDateButton) {
        this.byDateButton = byDateButton;
    }

    public FloatingActionButton getByCreatedButton() {
        return byCreatedButton;
    }

    public void setByCreatedButton(FloatingActionButton byCreatedButton) {
        this.byCreatedButton = byCreatedButton;
    }

    public Animation getFromBottom() {
        return fromBottom;
    }

    public void setFromBottom(Animation fromBottom) {
        this.fromBottom = fromBottom;
    }

    public Animation getToBottom() {
        return toBottom;
    }

    public void setToBottom(Animation toBottom) {
        this.toBottom = toBottom;
    }

    public ViewFloatingButton() {

    }


}
