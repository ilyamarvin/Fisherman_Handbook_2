package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ilyamarvin.fishermanhandbook2.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class FishCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7, expandableLayout8,
            expandableLayout9, expandableLayout10, expandableLayout11, expandableLayout12, expandableLayout13, expandableLayout14, expandableLayout15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_category);

        backBtn = findViewById(R.id.back_btn_fish);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FishCategory.super.onBackPressed();
            }
        });

    }

    public void expandableButton1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButton5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayout5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }

    public void expandableButton6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayout6);
        expandableLayout6.toggle(); // toggle expand and collapse
    }

    public void expandableButton7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayout7);
        expandableLayout7.toggle(); // toggle expand and collapse
    }
    public void expandableButton8(View view) {
        expandableLayout8 = findViewById(R.id.expandableLayout8);
        expandableLayout8.toggle(); // toggle expand and collapse
    }

    public void expandableButton9(View view) {
        expandableLayout9 = findViewById(R.id.expandableLayout9);
        expandableLayout9.toggle(); // toggle expand and collapse
    }

    public void expandableButton10(View view) {
        expandableLayout10 = findViewById(R.id.expandableLayout10);
        expandableLayout10.toggle(); // toggle expand and collapse
    }

    public void expandableButton11(View view) {
        expandableLayout11 = findViewById(R.id.expandableLayout11);
        expandableLayout11.toggle(); // toggle expand and collapse
    }

    public void expandableButton12(View view) {
        expandableLayout12 = findViewById(R.id.expandableLayout12);
        expandableLayout12.toggle(); // toggle expand and collapse
    }

    public void expandableButton13(View view) {
        expandableLayout13 = findViewById(R.id.expandableLayout13);
        expandableLayout13.toggle(); // toggle expand and collapse
    }

    public void expandableButton14(View view) {
        expandableLayout14 = findViewById(R.id.expandableLayout14);
        expandableLayout14.toggle(); // toggle expand and collapse
    }

    public void expandableButton15(View view) {
        expandableLayout15 = findViewById(R.id.expandableLayout15);
        expandableLayout15.toggle(); // toggle expand and collapse
    }


}
