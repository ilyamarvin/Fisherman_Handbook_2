package com.ilyamarvin.fishermanhandbook2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishAdapter;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishHelperClass;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView bestfishRecycler;
    RecyclerView.Adapter adapter;

    ImageView menuIcon;
    LinearLayout contentView;

    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        navigationDrawer();

        bestfishRecycler = findViewById(R.id.best_fish_recycler);
        bestfishRecycler();
    }

    //Navigation Drawer функции
    private void navigationDrawer() {

        //Меню слева
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_menu);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
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
