package com.example.app26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainApp7 extends AppCompatActivity {
    Button btn71, btn72;
    TextView txt71;
    EditText editText7Nom,editText7Prenom,editText7Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_app7);

        btn71 = findViewById(R.id.btn71);
        btn72 = findViewById(R.id.btn7);
        txt71 = findViewById(R.id.txt71);
        editText7Nom=findViewById(R.id.editText7Nom);
        editText7Prenom=findViewById(R.id.editText7Prenom);
        editText7Email=findViewById(R.id.editText7Email);

        btn71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt71.setText("BONJOUR");
            }
        });

        btn72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom = editText7Nom.getText().toString();
                String Prenom = editText7Prenom.getText().toString();
                String Email = editText7Email.getText().toString();
                Intent i = new Intent(MainApp7.this, MainApp72.class);
                i.putExtra("NOM",Nom);
                i.putExtra("PRENOM",Prenom);
                i.putExtra("EMAIL",Email);
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