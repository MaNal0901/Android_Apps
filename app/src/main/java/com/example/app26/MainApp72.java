package com.example.app26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainApp72 extends AppCompatActivity {
    TextView txt72 , txtv7Nom,txtv7Prenom,txtv7Email;

    Button btn72;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_app72);
         txt72=findViewById(R.id.txt72);
         btn72=findViewById(R.id.btn72);
        txtv7Nom=findViewById(R.id.textVcopi7Nom);
        txtv7Prenom=findViewById(R.id.textVcopi7Prenom);
        txtv7Email=findViewById(R.id.textVcopi7Email);
        Intent intent = getIntent();
        String texteRecuNom = intent.getStringExtra("NOM");
        String texteRecuPrenom = intent.getStringExtra("PRENOM");
        String texteRecuEmail= intent.getStringExtra("EMAIL");


        txtv7Nom.setText(texteRecuNom);
        txtv7Prenom.setText(texteRecuPrenom);
        txtv7Email.setText(texteRecuEmail);


        btn72.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(getApplicationContext(),MainApp7.class);
                 startActivity(i);
             }
         });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}