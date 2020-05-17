package com.ilyamarvin.fishermanhandbook2.MenuCategories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ilyamarvin.fishermanhandbook2.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class RigCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4;
    String poplavok_des, feeder_des, donka_des, spinning_des;
    TextView poplavok, feeder, donka, spinning;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rig_category);

        poplavok = findViewById(R.id.poplavok_desc);
        feeder = findViewById(R.id.feeder_desc);
        donka = findViewById(R.id.donka_desc);
        spinning = findViewById(R.id.spinning_desc);

        reference = FirebaseDatabase.getInstance().getReference("rig");

        backBtn = findViewById(R.id.back_btn_rig);

        showAllUserData();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RigCategory.super.onBackPressed();
            }
        });
    }

    private void showAllUserData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    poplavok_des = dataSnapshot.child("poplavok").getValue().toString();
                    feeder_des = dataSnapshot.child("feeder").getValue().toString();
                    donka_des = dataSnapshot.child("donka").getValue().toString();
                    spinning_des = dataSnapshot.child("spinning").getValue().toString();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void expandableButtonRig1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutRig1);
        expandableLayout1.toggle();
        poplavok.setText(poplavok_des);
    }

    public void expandableButtonRig2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutRig2);
        expandableLayout2.toggle();
        feeder.setText(feeder_des);
    }

    public void expandableButtonRig3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutRig3);
        expandableLayout3.toggle();
        donka.setText(donka_des);
    }

    public void expandableButtonRig4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutRig4);
        expandableLayout4.toggle();
        spinning.setText(spinning_des);
    }
}
