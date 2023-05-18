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
    ImageView setting;
    private RecyclerView discountedRecycler, categoryRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawerLayout = findViewById(R.id.drawer_layout);
        setting = findViewById(R.id.imgView_setting);

        discountedRecycler = findViewById(R.id.discountedRecycler);
        categoryRecycler = findViewById(R.id.categoryRecycler);

        //btnKeyboard.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {

                //Intent intent = new Intent(historyActivity.this, MainActivity.class);
                //startActivity(intent);

                //Toast.makeText(historyActivity.this, "Go to the keyboard page", Toast.LENGTH_SHORT).show();


            //}
        //});
    }

}





