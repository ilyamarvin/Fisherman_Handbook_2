package com.ilyamarvin.fishermanhandbook2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishAdapter;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishHelperClass;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    RecyclerView bestfishRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        bestfishRecycler = findViewById(R.id.best_fish_recycler);
        bestfishRecycler();
    }

    private void bestfishRecycler() {
        bestfishRecycler.setHasFixedSize(true);
        bestfishRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<BestFishHelperClass> bestFishLocations = new ArrayList<>();

        bestFishLocations.add(new BestFishHelperClass(R.drawable.karas, "Карась", "Рыба"));
        bestFishLocations.add(new BestFishHelperClass(R.drawable.karp, "Карп", "Рыба"));
        bestFishLocations.add(new BestFishHelperClass(R.drawable.amur, "Амур", "Рыба"));

        adapter = new BestFishAdapter(bestFishLocations);
        bestfishRecycler.setAdapter(adapter);
    }
}
