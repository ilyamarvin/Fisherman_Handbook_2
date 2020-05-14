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
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishAdapter;
import com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter.BestFishHelperClass;
import com.ilyamarvin.fishermanhandbook2.LoginScreen.LoginActivity;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.ArtbaitCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.BaitCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.FishCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.HooksCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.LureCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.RigCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.TipsCategory;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.UserProfile;
import com.ilyamarvin.fishermanhandbook2.MenuCategories.WeatherCategory;
import com.ilyamarvin.fishermanhandbook2.Settings.SettingsActivity;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView bestfishRecycler;
    RecyclerView.Adapter adapter;


    ImageView menuIcon, settingsIcon;
    LinearLayout contentView;
    RelativeLayout menuFish, menuHooks, menuArtbait, menuBait, menuRig, menuLure, menuTips, menuWeather;

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
        settingsIcon = findViewById(R.id.settings_icon);
        menuFish = findViewById(R.id.menu_fish);
        menuHooks = findViewById(R.id.menu_hooks);
        menuArtbait = findViewById(R.id.menu_artbait);
        menuBait = findViewById(R.id.menu_bait);
        menuRig = findViewById(R.id.menu_rig);
        menuLure = findViewById(R.id.menu_lure);
        menuTips = findViewById(R.id.menu_tips);
        menuWeather = findViewById(R.id.menu_weather);
        contentView = findViewById(R.id.content);

        navigationDrawer();

        bestfishRecycler = findViewById(R.id.best_fish_recycler);
        bestfishRecycler();

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

        menuArtbait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ArtbaitCategory.class));
            }
        });

        menuBait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BaitCategory.class));
            }
        });

        menuRig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RigCategory.class));
            }
        });

        menuLure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LureCategory.class));
            }
        });
        menuTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TipsCategory.class));
            }
        });
        menuWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WeatherCategory.class));
            }
        });

        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            }
        });
    }

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
            case R.id.nav_artbait:
                startActivity(new Intent(getApplicationContext(), ArtbaitCategory.class));
                break;
            case R.id.nav_bait:
                startActivity(new Intent(getApplicationContext(), BaitCategory.class));
                break;
            case R.id.nav_rig:
                startActivity(new Intent(getApplicationContext(), RigCategory.class));
                break;
            case R.id.nav_lure:
                startActivity(new Intent(getApplicationContext(), LureCategory.class));
                break;
            case R.id.nav_tips:
                startActivity(new Intent(getApplicationContext(), TipsCategory.class));
                break;
            case R.id.nav_weather:
                startActivity(new Intent(getApplicationContext(), WeatherCategory.class));
                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.nav_profile:
                startActivity(new Intent(getApplicationContext(), UserProfile.class));
                break;
            case R.id.nav_logout:
                Toast.makeText(this,"Выйти из аккаунта", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Я пользуюсь приложением Fisherman Handbook Середы Ильи! https://github.com/ilyamarvin/Fisherman_Handbook_2");
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                break;
            case R.id.nav_rate:
                Toast.makeText(this,"Оценить приложение", Toast.LENGTH_LONG).show();
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
