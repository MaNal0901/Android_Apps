package com.example.app26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {
    Button  btnActivite1,btnActivite5,btnActivite7,btnActivite8,btnActivite11,btnActivite11Chifrres , btnActivite_Animaux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        btnActivite1=findViewById(R.id.btnMain1);
        btnActivite5=findViewById(R.id.btnactivity_5);
        btnActivite7=findViewById(R.id.btnactivity_7);
        btnActivite8=findViewById(R.id.btnactivity_8);
        btnActivite11=findViewById(R.id.btnactivity_11);
        btnActivite11Chifrres=findViewById(R.id.btnactivity_11_2);
        btnActivite_Animaux=findViewById(R.id.btnactivity_12);
        btnActivite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnActivite5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, app_activity5.class);
                startActivity(intent);
            }
        });
        btnActivite7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, MainApp7.class);
                startActivity(intent);
            }
        });
        btnActivite8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, App8.class);
                startActivity(intent);
            }
        });
        btnActivite11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, App11.class);
                startActivity(intent);
            }
        });
        btnActivite11Chifrres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, app11partie2.class);
                startActivity(intent);
            }
        });
        btnActivite_Animaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, animaux.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}