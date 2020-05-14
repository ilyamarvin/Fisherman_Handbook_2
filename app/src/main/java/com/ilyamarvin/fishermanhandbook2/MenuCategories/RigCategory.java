package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ilyamarvin.fishermanhandbook2.R;

public class RigCategory extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rig_category);

        backBtn = findViewById(R.id.back_btn_rig);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RigCategory.super.onBackPressed();
            }
        });
    }
}
