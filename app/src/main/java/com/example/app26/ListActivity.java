package com.example.app26;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Button btnAjouter;
    ArrayList<String> pays;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        listView   = findViewById(R.id.listView);
        btnAjouter = findViewById(R.id.btnAjouterList);

        pays = new ArrayList<>(Arrays.asList(
                "France", "Maroc", "America", "Russe", "Espagne",
                "Italie", "Allemagne", "Portugal", "Brésil", "Mexique",
                "Canada", "Korea", "Chine", "Japon", "Inde",
                "Turquie", "Russie", "Égypte", "Sénégal","Cameroun"
        ));

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, pays);
        listView.setAdapter(adapter);

        // Toast au clic
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Pays sélectionné : " + pays.get(position),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Modification / Suppression au long clic
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Action sur : " + pays.get(position));
                builder.setItems(new String[]{"Modifier", "Supprimer"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) {
                                    dialogModifier(position);
                                } else {
                                    pays.remove(position);
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(getApplicationContext(),
                                            "Pays supprimé", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                builder.show();
                return true;
            }
        });


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

    private void dialogModifier(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modifier le pays");

        final EditText input = new EditText(this);
        input.setText(pays.get(position));
        builder.setView(input);

        builder.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nom = input.getText().toString().trim();
                if (!nom.isEmpty()) {
                    pays.set(position, nom);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(),
                            "Pays modifié", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }

}