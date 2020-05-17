package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ilyamarvin.fishermanhandbook2.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class ArtbaitCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artbait_category);

        backBtn = findViewById(R.id.back_btn_artbait);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArtbaitCategory.super.onBackPressed();
            }
        });
    }

    public void expandableButtonArtbait1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutArtbait1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButtonArtbait2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutArtbait2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButtonArtbait3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutArtbait3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButtonArtbait4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutArtbait4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButtonArtbait5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutArtbait5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }

    public void expandableButtonArtbait6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutArtbait6);
        expandableLayout6.toggle(); // toggle expand and collapse
    }

    public void expandableButtonArtbait7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutArtbait7);
        expandableLayout7.toggle(); // toggle expand and collapse
    }
}
