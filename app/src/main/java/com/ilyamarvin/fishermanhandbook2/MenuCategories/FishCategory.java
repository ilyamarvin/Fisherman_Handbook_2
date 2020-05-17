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

public class FishCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7, expandableLayout8,
            expandableLayout9, expandableLayout10, expandableLayout11, expandableLayout12, expandableLayout13, expandableLayout14, expandableLayout15;
    String ukleyka_des, plotva_des, elec_des, krasnoperka_des, karas_des, karp_des, shuka_des, lesh_des, som_des, okun_des, golavl_des, zhereh_des, yaz_des, gustera_des, amur_des;
    TextView ukleyka, plotva, elec, krasnoperka, karas, karp, shuka, lesh, som, okun, golavl, zhereh, yaz, gustera, amur;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_category);

        ukleyka = findViewById(R.id.ukleyka_description);
        plotva = findViewById(R.id.plotva_description);
        elec = findViewById(R.id.elec_description);
        krasnoperka = findViewById(R.id.krasnoperka_description);
        karas = findViewById(R.id.karas_description);
        karp = findViewById(R.id.karp_description);
        shuka = findViewById(R.id.shuka_description);
        lesh = findViewById(R.id.lesh_description);
        som = findViewById(R.id.som_description);
        lesh = findViewById(R.id.lesh_description);
        okun = findViewById(R.id.okun_description);
        golavl = findViewById(R.id.golavl_description);
        zhereh = findViewById(R.id.zhereh_description);
        yaz = findViewById(R.id.yaz_description);
        gustera = findViewById(R.id.gustera_description);
        amur = findViewById(R.id.amur_description);

        reference = FirebaseDatabase.getInstance().getReference("fishes");

        backBtn = findViewById(R.id.back_btn_fish);

        showAllUserData();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FishCategory.super.onBackPressed();
            }
        });

    }

    private void showAllUserData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    ukleyka_des = dataSnapshot.child("ukleyka").getValue().toString();
                    plotva_des = dataSnapshot.child("plotva").getValue().toString();
                    elec_des = dataSnapshot.child("elec").getValue().toString();
                    krasnoperka_des = dataSnapshot.child("krasnoperka").getValue().toString();
                    karas_des = dataSnapshot.child("karas").getValue().toString();
                    karp_des = dataSnapshot.child("karp").getValue().toString();
                    shuka_des = dataSnapshot.child("shuka").getValue().toString();
                    lesh_des = dataSnapshot.child("lesh").getValue().toString();
                    som_des = dataSnapshot.child("som").getValue().toString();
                    okun_des = dataSnapshot.child("okun").getValue().toString();
                    golavl_des = dataSnapshot.child("golavl").getValue().toString();
                    zhereh_des = dataSnapshot.child("zhereh").getValue().toString();
                    yaz_des = dataSnapshot.child("yaz").getValue().toString();
                    gustera_des = dataSnapshot.child("gustera").getValue().toString();
                    amur_des = dataSnapshot.child("amur").getValue().toString();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void expandableButtonFish1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutFish1);
        expandableLayout1.toggle();
        ukleyka.setText(ukleyka_des);
    }

    public void expandableButtonFish2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutFish2);
        expandableLayout2.toggle();
        plotva.setText(plotva_des);
    }

    public void expandableButtonFish3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutFish3);
        expandableLayout3.toggle();
        elec.setText(elec_des);
    }

    public void expandableButtonFish4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutFish4);
        expandableLayout4.toggle();
        krasnoperka.setText(krasnoperka_des);
    }

    public void expandableButtonFish5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutFish5);
        expandableLayout5.toggle();
        karas.setText(karas_des);
    }

    public void expandableButtonFish6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutFish6);
        expandableLayout6.toggle();
        karp.setText(karp_des);
    }

    public void expandableButtonFish7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutFish7);
        expandableLayout7.toggle();
        shuka.setText(shuka_des);
    }
    public void expandableButtonFish8(View view) {
        expandableLayout8 = findViewById(R.id.expandableLayoutFish8);
        expandableLayout8.toggle();
        lesh.setText(lesh_des);
    }

    public void expandableButtonFish9(View view) {
        expandableLayout9 = findViewById(R.id.expandableLayoutFish9);
        expandableLayout9.toggle();
        som.setText(som_des);
    }

    public void expandableButtonFish10(View view) {
        expandableLayout10 = findViewById(R.id.expandableLayoutFish10);
        expandableLayout10.toggle();
        okun.setText(okun_des);
    }

    public void expandableButtonFish11(View view) {
        expandableLayout11 = findViewById(R.id.expandableLayoutFish11);
        expandableLayout11.toggle();
        golavl.setText(golavl_des);
    }

    public void expandableButtonFish12(View view) {
        expandableLayout12 = findViewById(R.id.expandableLayoutFish12);
        expandableLayout12.toggle();
        zhereh.setText(zhereh_des);
    }

    public void expandableButtonFish13(View view) {
        expandableLayout13 = findViewById(R.id.expandableLayoutFish13);
        expandableLayout13.toggle();
        yaz.setText(yaz_des);
    }

    public void expandableButtonFish14(View view) {
        expandableLayout14 = findViewById(R.id.expandableLayoutFish14);
        expandableLayout14.toggle();
        gustera.setText(gustera_des);
    }

    public void expandableButtonFish15(View view) {
        expandableLayout15 = findViewById(R.id.expandableLayoutFish15);
        expandableLayout15.toggle();
        amur.setText(amur_des);
    }


}
