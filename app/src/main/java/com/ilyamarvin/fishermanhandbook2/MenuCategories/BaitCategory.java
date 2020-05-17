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

public class BaitCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7, expandableLayout8,
            expandableLayout9, expandableLayout10;
    String chervi_des, lichinki_des, nasekomie_des, jivci_des, orehi_des, tonush_des, popup_des, pellets_des, kukuruza_des, dipi_des;
    TextView chervi, lichinki, nasekomie, jivci, orehi, tonush, popup, pellets, kukuruza, dipi;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bait_category);

        chervi = findViewById(R.id.chervi_desc);
        lichinki = findViewById(R.id.lichinki_desc);
        nasekomie = findViewById(R.id.nasekomie_desc);
        jivci = findViewById(R.id.jivci_desc);
        orehi = findViewById(R.id.orehi_desc);
        tonush = findViewById(R.id.tonush_desc);
        popup = findViewById(R.id.popup_desc);
        pellets = findViewById(R.id.pellets_desc);
        kukuruza = findViewById(R.id.kukuruza_desc);
        dipi = findViewById(R.id.dipi_desc);

        reference = FirebaseDatabase.getInstance().getReference("baits");

        backBtn = findViewById(R.id.back_btn_bait);

        showAllUserData();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaitCategory.super.onBackPressed();
            }
        });
    }

    private void showAllUserData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    chervi_des = dataSnapshot.child("chervi").getValue().toString();
                    lichinki_des = dataSnapshot.child("lichinki").getValue().toString();
                    nasekomie_des = dataSnapshot.child("nasekomie").getValue().toString();
                    jivci_des = dataSnapshot.child("jivci").getValue().toString();
                    orehi_des = dataSnapshot.child("orehi").getValue().toString();
                    tonush_des = dataSnapshot.child("tonush").getValue().toString();
                    popup_des = dataSnapshot.child("popup").getValue().toString();
                    pellets_des = dataSnapshot.child("pellets").getValue().toString();
                    kukuruza_des = dataSnapshot.child("kukuruza").getValue().toString();
                    dipi_des = dataSnapshot.child("dipi").getValue().toString();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void expandableButtonBait1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutBait1);
        expandableLayout1.toggle();
        chervi.setText(chervi_des);
    }

    public void expandableButtonBait2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutBait2);
        expandableLayout2.toggle();
        lichinki.setText(lichinki_des);
    }

    public void expandableButtonBait3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutBait3);
        expandableLayout3.toggle();
        nasekomie.setText(nasekomie_des);
    }

    public void expandableButtonBait4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutBait4);
        expandableLayout4.toggle();
        jivci.setText(jivci_des);
    }

    public void expandableButtonBait5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutBait5);
        expandableLayout5.toggle();
        orehi.setText(orehi_des);
    }

    public void expandableButtonBait6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutBait6);
        expandableLayout6.toggle();
        tonush.setText(tonush_des);
    }

    public void expandableButtonBait7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutBait7);
        expandableLayout7.toggle();
        popup.setText(popup_des);
    }
    public void expandableButtonBait8(View view) {
        expandableLayout8 = findViewById(R.id.expandableLayoutBait8);
        expandableLayout8.toggle();
        pellets.setText(pellets_des);
    }

    public void expandableButtonBait9(View view) {
        expandableLayout9 = findViewById(R.id.expandableLayoutBait9);
        expandableLayout9.toggle();
        kukuruza.setText(kukuruza_des);
    }

    public void expandableButtonBait10(View view) {
        expandableLayout10 = findViewById(R.id.expandableLayoutBait10);
        expandableLayout10.toggle();
        dipi.setText(dipi_des);
    }
}
