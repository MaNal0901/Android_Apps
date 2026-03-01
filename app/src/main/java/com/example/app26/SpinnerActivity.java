package com.example.app26;
import android.view.View;
import android.os.Bundle;
import android.content.DialogInterface;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;
    Button btnAjouter, btnModifier, btnSupprimer;
    ArrayList<String> pays;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        spinner      = findViewById(R.id.spinner);
        btnAjouter   = findViewById(R.id.btnAjouterSpinner);
        btnModifier  = findViewById(R.id.btnModifierSpinner);
        btnSupprimer = findViewById(R.id.btnSupprimerSpinner);
        pays = new ArrayList<>(Arrays.asList(
                "France", "Maroc", "Algérie", "Tunisie", "Espagne",
                "Italie", "Allemagne", "Portugal", "Brésil", "Mexique",
                "Canada", "États-Unis", "Chine", "Japon", "Inde",
                "Turquie", "Russie", "Égypte", "Sénégal", "Cameroun"
        ));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pays);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Sélectionné : " + pays.get(position),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        // Ajouter
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAjouter();
            }
        });
        // Modifier
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spinner.getSelectedItemPosition();
                if (pos >= 0) dialogModifier(pos);
            }
        });
        // Supprimer
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int pos = spinner.getSelectedItemPosition();
                if (pos >= 0) {
                    new AlertDialog.Builder(SpinnerActivity.this)
                            .setTitle("Supprimer")
                            .setMessage("Supprimer " + pays.get(pos) + " ?")
                            .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    pays.remove(pos);
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(getApplicationContext(),
                                            "Pays supprimé", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("Non", null)
                            .show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void dialogModifier(int pos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter un pays");

        final EditText input = new EditText(this);
        input.setHint("Nom du pays");
        builder.setView(input);

        builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nom = input.getText().toString().trim();
                if (!nom.isEmpty()) {
                    pays.add(nom);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(),
                            nom + " ajouté", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }

    private void dialogAjouter() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter un pays");

        final EditText input = new EditText(this);
        input.setHint("Nom du pays");
        builder.setView(input);

        builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nom = input.getText().toString().trim();
                if (!nom.isEmpty()) {
                    pays.add(nom);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(),
                            nom + " ajouté", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }
}