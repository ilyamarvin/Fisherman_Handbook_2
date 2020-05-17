package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ilyamarvin.fishermanhandbook2.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class RigCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4;

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

    public void expandableButtonRig1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutRig1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButtonRig2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutRig2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButtonRig3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutRig3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButtonRig4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutRig4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }
}
