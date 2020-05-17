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

    public void expandableButtonFish1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutFish1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutFish2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutFish3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutFish4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutFish5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutFish6);
        expandableLayout6.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutFish7);
        expandableLayout7.toggle(); // toggle expand and collapse
    }
    public void expandableButtonFish8(View view) {
        expandableLayout8 = findViewById(R.id.expandableLayoutFish8);
        expandableLayout8.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish9(View view) {
        expandableLayout9 = findViewById(R.id.expandableLayoutFish9);
        expandableLayout9.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish10(View view) {
        expandableLayout10 = findViewById(R.id.expandableLayoutFish10);
        expandableLayout10.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish11(View view) {
        expandableLayout11 = findViewById(R.id.expandableLayoutFish11);
        expandableLayout11.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish12(View view) {
        expandableLayout12 = findViewById(R.id.expandableLayoutFish12);
        expandableLayout12.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish13(View view) {
        expandableLayout13 = findViewById(R.id.expandableLayoutFish13);
        expandableLayout13.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish14(View view) {
        expandableLayout14 = findViewById(R.id.expandableLayoutFish14);
        expandableLayout14.toggle(); // toggle expand and collapse
    }

    public void expandableButtonFish15(View view) {
        expandableLayout15 = findViewById(R.id.expandableLayoutFish15);
        expandableLayout15.toggle(); // toggle expand and collapse
    }


}
