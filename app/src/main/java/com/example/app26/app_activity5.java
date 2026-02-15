package com.example.app26;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class app_activity5 extends AppCompatActivity {
    EditText editTextVar1, editTextVar2, editTextResult;
    Button btnAddition, btnSoustraction, btnMultiplication, btnDivision, btnClear, btnEgal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app5);

        editTextVar1 = findViewById(R.id.edtxt1);
        editTextVar2 = findViewById(R.id.edtxt2);
        editTextResult = findViewById(R.id.editText_resultat);
        btnAddition = findViewById(R.id.btn_addition);
        btnSoustraction = findViewById(R.id.btn_soustraction);
        btnMultiplication = findViewById(R.id.btn_multiplication);
        btnDivision = findViewById(R.id.btn_division);
        btnClear = findViewById(R.id.btn_clear);
        btnEgal = findViewById(R.id.btn_egal);

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer("+");
            }
        });

        btnSoustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer("-");
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer("*");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer("/");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextVar1.setText("");
                editTextVar2.setText("");
                editTextResult.setText("");
            }
        });

        btnEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultat = editTextResult.getText().toString();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void calculer(String operation) {

            String strVar1 = editTextVar1.getText().toString().trim();
            String strVar2 = editTextVar2.getText().toString().trim();


            double var1 = Double.parseDouble(strVar1);
            double var2 = Double.parseDouble(strVar2);
            double resultat = 0;


            switch (operation) {
                case "+":
                    resultat = var1 + var2;
                    break;
                case "-":
                    resultat = var1 - var2;
                    break;
                case "*":
                    resultat = var1 * var2;
                    break;
                case "/":
                    if (var2 == 0) {

                        editTextResult.setText("Erreur");
                        return;
                    }
                    resultat = var1 / var2;
                    break;
            }


            if (resultat == (long) resultat) {
                // un entier , sans décimales
                editTextResult.setText(String.valueOf((long) resultat));
            } else {

                editTextResult.setText(String.format("%.2f", resultat));
            }
    }
}