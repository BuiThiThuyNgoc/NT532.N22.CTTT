package com.example.mini_mart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CartDetailPage extends AppCompatActivity {
    ImageView backProductDetail;
    Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail_page);

        backProductDetail = findViewById(R.id.backProductDetail);
        btn_order = findViewById(R.id.btn_order);

        backProductDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartDetailPage.this, CartPage.class);
                startActivity(intent);
            }
        });

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartDetailPage.this, PaymentPage.class);
                startActivity(intent);
            }
        });
    }
}