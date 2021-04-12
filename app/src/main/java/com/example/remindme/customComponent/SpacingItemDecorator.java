/*
* Original code by EyesClear
* https://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-between-items-in-recyclerview
* Edited by Naufal Taufik A
*
* Melakukan extends ke component ItemDecoration dan menambahkan
* beberapa method custom
* Dibuat dengan tujuan agar dapat memberi space atau jarak
* tiap item pada recyclerview
* */

package com.example.remindme.customComponent;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpacingItemDecorator extends RecyclerView.ItemDecoration {
    private int bottomHeight;
    private int leftHeight;
    private int rightHeight;

    public SpacingItemDecorator(int bottomHeight, int leftHeight, int rightHeight) {
        this.bottomHeight = bottomHeight;
        this.leftHeight = leftHeight;
        this.rightHeight = rightHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = bottomHeight;
        outRect.left = leftHeight;
        outRect.right = leftHeight;
    }
}
