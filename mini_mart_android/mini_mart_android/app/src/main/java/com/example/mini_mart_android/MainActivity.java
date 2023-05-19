package com.example.mini_mart_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.mini_mart_android.adapter.CategoryAdapter;
//import com.example.mini_mart_android.adapter.ProductAdapter;
import com.example.mini_mart_android.Adapter.MainAdapter;
import com.example.mini_mart_android.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewPager = findViewById(R.id.vpg_main);
        bottomNavigationView = findViewById(R.id.menu_bottom);

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(mainAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.action_product).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.action_promotion).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.action_shoppingCart).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.action_notification).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.action_account).setChecked(true);
                        break;
                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_product:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_promotion:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_shoppingCart:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_notification:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.action_account:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }

}





