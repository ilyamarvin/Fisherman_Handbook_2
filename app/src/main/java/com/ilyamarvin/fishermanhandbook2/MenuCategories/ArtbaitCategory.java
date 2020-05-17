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

public class ArtbaitCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7;
    String vrash_des, koleb_des, vobler_des, topvoter_des, djerk_des, myag_des, vecki_des;
    TextView vrash, koleb, vobler, topvoter, djerk, myag, vecki;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artbait_category);

        vrash = findViewById(R.id.vrash_desc);
        koleb = findViewById(R.id.koleb_desc);
        vobler = findViewById(R.id.vobler_desc);
        topvoter = findViewById(R.id.topvoter_desc);
        djerk = findViewById(R.id.djerkbait_desc);
        myag = findViewById(R.id.myag_desc);
        vecki = findViewById(R.id.vecki_desc);

        reference = FirebaseDatabase.getInstance().getReference("artbait");

        showAllUserData();

        backBtn = findViewById(R.id.back_btn_artbait);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArtbaitCategory.super.onBackPressed();
            }
        });
    }

    private void showAllUserData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    vrash_des = dataSnapshot.child("vrash").getValue().toString();
                    koleb_des = dataSnapshot.child("koleb").getValue().toString();
                    vobler_des = dataSnapshot.child("vobler").getValue().toString();
                    topvoter_des = dataSnapshot.child("topvoter").getValue().toString();
                    djerk_des = dataSnapshot.child("djerkbait").getValue().toString();
                    myag_des = dataSnapshot.child("myag").getValue().toString();
                    vecki_des = dataSnapshot.child("vecki").getValue().toString();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void expandableButtonArtbait1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutArtbait1);
        expandableLayout1.toggle();
        vrash.setText(vrash_des);
    }

    public void expandableButtonArtbait2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutArtbait2);
        expandableLayout2.toggle();
        koleb.setText(koleb_des);
    }

    public void expandableButtonArtbait3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutArtbait3);
        expandableLayout3.toggle();
        vobler.setText(vobler_des);
    }

    public void expandableButtonArtbait4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutArtbait4);
        expandableLayout4.toggle();
        topvoter.setText(topvoter_des);
    }

    public void expandableButtonArtbait5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutArtbait5);
        expandableLayout5.toggle();
        djerk.setText(djerk_des);
    }

    public void expandableButtonArtbait6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutArtbait6);
        expandableLayout6.toggle();
        myag.setText(myag_des);
    }

    public void expandableButtonArtbait7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutArtbait7);
        expandableLayout7.toggle();
        vecki.setText(vecki_des);
    }
}
