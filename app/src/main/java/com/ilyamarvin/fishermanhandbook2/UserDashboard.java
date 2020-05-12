package com.ilyamarvin.fishermanhandbook2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishAdapter;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishHelperClass;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.FishCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.HooksCategory;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView bestfishRecycler;
    RecyclerView.Adapter adapter;

    ImageView menuIcon;
    LinearLayout contentView;
    RelativeLayout menuFish, menuHooks;

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
        menuFish = findViewById(R.id.menu_fish);
        menuHooks = findViewById(R.id.menu_hooks);
        contentView = findViewById(R.id.content);

        navigationDrawer();

        bestfishRecycler = findViewById(R.id.best_fish_recycler);
        bestfishRecycler();

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

        menuFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FishCategory.class));
            }
        });

        menuHooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HooksCategory.class));
            }
        });
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

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

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

        switch (item.getItemId()) {
            case R.id.nav_menu:
                drawerLayout.closeDrawer(GravityCompat.START);
            break;
            case R.id.nav_fish:
                startActivity(new Intent(getApplicationContext(), FishCategory.class));
                break;
            case R.id.nav_hooks:
                startActivity(new Intent(getApplicationContext(), HooksCategory.class));
                break;
        }
        return true;
    }

    private void bestfishRecycler() {
        bestfishRecycler.setHasFixedSize(true);
        bestfishRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<BestFishHelperClass> bestFishLocations = new ArrayList<>();

        bestFishLocations.add(new BestFishHelperClass(R.drawable.karas, "Карась", "Караси (лат. Carassius) — род лучепёрых рыб семейства карповых."));
        bestFishLocations.add(new BestFishHelperClass(R.drawable.karp, "Карп", "Карпы (лат. Cyprinus) — род рыб семейства карповых."));
        bestFishLocations.add(new BestFishHelperClass(R.drawable.amur, "Амур", "Белый амур (лат. Ctenopharyngodon idella) — вид лучепёрых рыб семейства карповых."));

        adapter = new BestFishAdapter(bestFishLocations);
        bestfishRecycler.setAdapter(adapter);
    }
}
