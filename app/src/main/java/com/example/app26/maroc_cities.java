package com.example.app26;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;        // ✅ import manquant ajouté
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class maroc_cities extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAjouter;
    VilleAdapter adapter;

    ArrayList<String> villes = new ArrayList<>(Arrays.asList(
            "tanger", "laaraych",
            "chefchaouen", "fes", "marakech",
            "asfi", "el jadida",
            "casablanca", "agadir", "essaouira"
    ));

    ArrayList<Integer> images = new ArrayList<>(Arrays.asList(
            R.drawable.tanger,
            R.drawable.laaraych,
            R.drawable.chefchaouen,
            R.drawable.fes,
            R.drawable.marakech,
            R.drawable.asfi,
            R.drawable.el_jadida,
            R.drawable.casablanca,
            R.drawable.agadir,
            R.drawable.essaouira
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_maroc_cities);

        recyclerView = findViewById(R.id.recyclerView);
        btnAjouter   = findViewById(R.id.btnAjouter);

        adapter = new VilleAdapter(this, villes, images);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAjouter();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void dialogAjouter() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter une ville");

        final EditText input = new EditText(this);
        input.setHint("Nom de la ville");
        builder.setView(input);

        builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nom = input.getText().toString().trim();
                if (!nom.isEmpty()) {
                    adapter.ajouterVille(nom, R.drawable.casablanca);
                    Toast.makeText(getApplicationContext(),
                            nom + " ajoutée", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }
}