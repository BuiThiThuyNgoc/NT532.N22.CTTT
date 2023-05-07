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
    //private ProductAdapter productAdapter;
    //private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawerLayout = findViewById(R.id.drawer_layout);
        setting = findViewById(R.id.imgView_setting);

        discountedRecycler = findViewById(R.id.discountedRecycler);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        //productAdapter= new ProductAdapter(this);
        //categoryAdapter = new CategoryAdapter(this);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        discountedRecycler.setLayoutManager(gridLayoutManager);
        categoryRecycler.setLayoutManager(gridLayoutManager);

        //productAdapter.setData(getListProduct());
        //categoryAdapter.setData(getListCategory());
        //discountedRecycler.setAdapter(productAdapter);
        //categoryRecycler.setAdapter(categoryAdapter);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(MainActivity.this, Header.class);
                startActivity(back);
                finish();
            }
        });



    }
    //    call from api
    //private List<Product> getListProduct() {
       // List<Product> list = new ArrayList<>();
       // list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
       // list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
       // list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
       // list.add(new Product(R.drawable.img, "produc1"));

        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));
        //list.add(new Product(R.drawable.img, "produc1"));

        //return list;

    }
    //private List<Category> getListCategory() {
        //List<Category> list = new ArrayList<>();
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
        //list.add(new Category( "category1"));
       // list.add(new Category( "category1"));

        //return list;

    //}
//}