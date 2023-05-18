package com.example.mini_mart_android;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.mini_mart_android.adapter.CategoryAdapter;
//import com.example.mini_mart_android.adapter.ProductAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ImageView setting, imgView_cart;
    private TextView tv_viewdDiscountedItems, tv_viewAllCategory;
    private RecyclerView discountedRecycler, categoryRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawerLayout = findViewById(R.id.drawer_layout);
        setting = findViewById(R.id.imgView_setting);
        imgView_cart = findViewById(R.id.imgView_cart);

        tv_viewdDiscountedItems = findViewById(R.id.tv_viewdDiscountedItems);
        tv_viewAllCategory = findViewById(R.id.tv_viewAllCategory);

        discountedRecycler = findViewById(R.id.discountedRecycler);
        categoryRecycler = findViewById(R.id.categoryRecycler);

        imgView_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CartDetailPage.class);
                startActivity(intent);
            }
        });

        tv_viewdDiscountedItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItemDiscount.class);
                startActivity(intent);
            }
        });
        tv_viewAllCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryPage.class);
                startActivity(intent);
            }
        });


    }

}





