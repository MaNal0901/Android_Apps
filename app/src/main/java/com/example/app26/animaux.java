package com.example.app26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class animaux extends AppCompatActivity {
    TextView titre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animaux);
        titre=findViewById(R.id.titreAnimaux);
        for (int i = 1; i <= 10; i++){
            final int imageNumber = i;
            String imageViewId = "imageAnim" + i;
            int resId = getResources().getIdentifier(imageViewId, "id", getPackageName());
            ImageView imageView = findViewById(resId);
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(animaux.this, animauxVideo.class);
                        intent.putExtra("VIDEO_NUMBER", imageNumber);
                        startActivity(intent);
                    }
                });
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}