package com.example.mini_mart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class OrderSuccessPage extends AppCompatActivity {
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success_page);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(OrderSuccessPage.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(OrderSuccessPage.this, "Go to the keyboard page", Toast.LENGTH_SHORT).show();


            }
        });
    }
}