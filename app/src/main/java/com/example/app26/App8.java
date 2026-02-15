package com.example.app26;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class App8 extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app8);
        btn1=findViewById(R.id.btn18);
        btn2=findViewById(R.id.btn28);
        btn3=findViewById(R.id.btn38);
        btn4=findViewById(R.id.btn48);
        btn5=findViewById(R.id.btn58);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "Toast durée courte", Toast.LENGTH_SHORT
                        );
                t.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "Toast durée longue", Toast.LENGTH_LONG);
                t.show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder boite = new AlertDialog.Builder(App8.this);
                boite.setTitle("Boîte de dialogue");
                boite.setIcon(android.R.drawable.ic_dialog_info);
                boite.setMessage("Ceci est une boîte de dialogue avec un seul bouton");
                boite.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(App8.this, "Bouton OK cliqué", Toast.LENGTH_SHORT).show();
                    }
                });
                boite.show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder boite = new AlertDialog.Builder(App8.this);
                boite.setTitle("Confirmation");
                boite.setIcon(android.R.drawable.ic_dialog_alert);
                boite.setMessage("Voulez-vous continuer ?");

                boite.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(App8.this, "Vous avez cliqué sur Oui", Toast.LENGTH_SHORT).show();
                    }
                });

                boite.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(App8.this, "Vous avez cliqué sur Non", Toast.LENGTH_SHORT).show();
                    }
                });

                boite.show();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder boite = new AlertDialog.Builder(App8.this);
                boite.setTitle("Saisie de données");
                boite.setIcon(android.R.drawable.ic_dialog_email);

                EditText input = new EditText(App8.this);
                input.setHint("Entrez votre nom");
                boite.setView(input);

                boite.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String texte = input.getText().toString();
                        Toast.makeText(App8.this, "Vous avez saisi : " + texte, Toast.LENGTH_LONG).show();
                    }
                });

                boite.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(App8.this, "Annulé", Toast.LENGTH_SHORT).show();
                    }
                });

                boite.setNeutralButton("Aide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(App8.this, "Bouton Aide cliqué", Toast.LENGTH_SHORT).show();
                    }
                });

                boite.show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}