package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ilyamarvin.fishermanhandbook2.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class HooksCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hooks_category);

        backBtn = findViewById(R.id.back_btn_hooks);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HooksCategory.super.onBackPressed();
            }
        });
    }

    public void expandableButtonHooks1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutHooks1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButtonHooks2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutHooks2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButtonHooks3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutHooks3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButtonHooks4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutHooks4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButtonHooks5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutHooks5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }

    public void expandableButtonHooks6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutHooks6);
        expandableLayout6.toggle(); // toggle expand and collapse
    }

    public void expandableButtonHooks7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutHooks7);
        expandableLayout7.toggle(); // toggle expand and collapse
    }
}
