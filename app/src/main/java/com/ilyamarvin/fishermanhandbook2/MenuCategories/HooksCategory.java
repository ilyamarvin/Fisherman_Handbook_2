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

public class HooksCategory extends AppCompatActivity {
    ImageView backBtn;
    ExpandableLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5, expandableLayout6, expandableLayout7;
    String classical_des, carp_des, ofset_des, troynik_des, dzhig_des, ogruz_des, jivec_des;
    TextView classical, carp, ofset, troynik, dzhig, ogruz, jivec;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hooks_category);

        classical = findViewById(R.id.classical_hook_desc);
        carp = findViewById(R.id.carp_hook_desc);
        ofset = findViewById(R.id.ofset_hook_desc);
        troynik = findViewById(R.id.troynik_hook_desc);
        dzhig = findViewById(R.id.dzhig_hook_desc);
        ogruz = findViewById(R.id.ogruz_hook_desc);
        jivec = findViewById(R.id.jivec_hook_desc);

        reference = FirebaseDatabase.getInstance().getReference("hooks");

        backBtn = findViewById(R.id.back_btn_hooks);

        showAllUserData();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HooksCategory.super.onBackPressed();
            }
        });
    }

    private void showAllUserData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    classical_des = dataSnapshot.child("classic").getValue().toString();
                    carp_des = dataSnapshot.child("carp").getValue().toString();
                    ofset_des = dataSnapshot.child("ofset").getValue().toString();
                    troynik_des = dataSnapshot.child("troynik").getValue().toString();
                    dzhig_des = dataSnapshot.child("djig").getValue().toString();
                    ogruz_des = dataSnapshot.child("ogruz").getValue().toString();
                    jivec_des = dataSnapshot.child("jivec").getValue().toString();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void expandableButtonHooks1(View view) {
        expandableLayout1 = findViewById(R.id.expandableLayoutHooks1);
        expandableLayout1.toggle();
        classical.setText(classical_des);
    }

    public void expandableButtonHooks2(View view) {
        expandableLayout2 = findViewById(R.id.expandableLayoutHooks2);
        expandableLayout2.toggle();
        carp.setText(carp_des);
    }

    public void expandableButtonHooks3(View view) {
        expandableLayout3 = findViewById(R.id.expandableLayoutHooks3);
        expandableLayout3.toggle();
        ofset.setText(ofset_des);
    }

    public void expandableButtonHooks4(View view) {
        expandableLayout4 = findViewById(R.id.expandableLayoutHooks4);
        expandableLayout4.toggle();
        troynik.setText(troynik_des);
    }

    public void expandableButtonHooks5(View view) {
        expandableLayout5 = findViewById(R.id.expandableLayoutHooks5);
        expandableLayout5.toggle();
        dzhig.setText(dzhig_des);
    }

    public void expandableButtonHooks6(View view) {
        expandableLayout6 = findViewById(R.id.expandableLayoutHooks6);
        expandableLayout6.toggle();
        ogruz.setText(ogruz_des);
    }

    public void expandableButtonHooks7(View view) {
        expandableLayout7 = findViewById(R.id.expandableLayoutHooks7);
        expandableLayout7.toggle();
        jivec.setText(jivec_des);
    }
}
