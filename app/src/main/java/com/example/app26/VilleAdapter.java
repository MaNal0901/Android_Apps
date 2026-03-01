package com.example.app26;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VilleAdapter extends RecyclerView.Adapter<VilleAdapter.VilleViewHolder> {

    Context context;
    ArrayList<String> villes;
    ArrayList<Integer> images;

    // ✅ Constructeur
    public VilleAdapter(Context context, ArrayList<String> villes, ArrayList<Integer> images) {
        this.context = context;
        this.villes  = villes;
        this.images  = images;
    }

    // ✅ ViewHolder : représente une seule ligne
    public static class VilleViewHolder extends RecyclerView.ViewHolder {
        ImageView imgVille;
        TextView  txtVille;
        Button    btnModifier, btnSupprimer;

        public VilleViewHolder(View itemView) {
            super(itemView);
            imgVille     = itemView.findViewById(R.id.imgVille);
            txtVille     = itemView.findViewById(R.id.txtVille);
            btnModifier  = itemView.findViewById(R.id.btnModifier);
            btnSupprimer = itemView.findViewById(R.id.btnSupprimer);
        }
    }

    // Crée la vue de chaque élément
    @Override
    public VilleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_ville, parent, false);
        return new VilleViewHolder(view);
    }

    //  Remplit les données dans chaque élément
    @Override
    public void onBindViewHolder(VilleViewHolder holder, int position) {

        holder.txtVille.setText(villes.get(position));
        holder.imgVille.setImageResource(images.get(position));

        // Bouton Modifier
        holder.btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                dialogModifier(pos);
            }
        });

        // Bouton Supprimer
        holder.btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                new AlertDialog.Builder(context)
                        .setTitle("Supprimer")
                        .setMessage("Supprimer " + villes.get(pos) + " ?")
                        .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                villes.remove(pos);
                                images.remove(pos);
                                notifyItemRemoved(pos);
                                Toast.makeText(context,
                                        "Ville supprimée", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Non", null)
                        .show();
            }
        });
    }

    // Nombre total d'éléments
    @Override
    public int getItemCount() {
        return villes.size();
    }

    // Dialog Modifier
    private void dialogModifier(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Modifier la ville");

        final EditText input = new EditText(context);
        input.setText(villes.get(position));
        builder.setView(input);

        builder.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nom = input.getText().toString().trim();
                if (!nom.isEmpty()) {
                    villes.set(position, nom);
                    notifyItemChanged(position);
                    Toast.makeText(context,
                            "Ville modifiée", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }

    //  Méthode publique pour ajouter depuis MainActivity
    public void ajouterVille(String nom, int image) {
        villes.add(nom);
        images.add(image);
        notifyItemInserted(villes.size() - 1);
    }
}