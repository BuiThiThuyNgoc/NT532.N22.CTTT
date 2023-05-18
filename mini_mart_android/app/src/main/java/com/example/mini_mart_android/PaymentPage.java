package com.example.mini_mart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PaymentPage extends AppCompatActivity {
    ImageView backCartDetail;
    Button btn_completethepurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        backCartDetail = findViewById(R.id.backCartDetail);
        btn_completethepurchase = findViewById(R.id.btn_completethepurchase);



        backCartDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentPage.this, CartDetailPage.class);
                startActivity(intent);
            }
        });
        btn_completethepurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentPage.this, OrderSuccessPage.class);
                startActivity(intent);
            }
        });
    }
}