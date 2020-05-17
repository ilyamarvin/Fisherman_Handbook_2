package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ilyamarvin.fishermanhandbook2.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class BaitCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7, expandableLayout8,
            expandableLayout9, expandableLayout10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bait_category);

        backBtn = findViewById(R.id.back_btn_bait);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaitCategory.super.onBackPressed();
            }
        });
    }

    public void expandableButtonBait1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutBait1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutBait2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutBait3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutBait4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutBait5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutBait6);
        expandableLayout6.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutBait7);
        expandableLayout7.toggle(); // toggle expand and collapse
    }
    public void expandableButtonBait8(View view) {
        expandableLayout8 = findViewById(R.id.expandableLayoutBait8);
        expandableLayout8.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait9(View view) {
        expandableLayout9 = findViewById(R.id.expandableLayoutBait9);
        expandableLayout9.toggle(); // toggle expand and collapse
    }

    public void expandableButtonBait10(View view) {
        expandableLayout10 = findViewById(R.id.expandableLayoutBait10);
        expandableLayout10.toggle(); // toggle expand and collapse
    }
}
