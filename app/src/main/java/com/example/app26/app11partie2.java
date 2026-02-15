package com.example.app26;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class app11partie2 extends AppCompatActivity {
    private int[] imageIds = {
            R.id.imageView1, R.id.imageView2, R.id.imageView3,
            R.id.imageView4, R.id.imageView5, R.id.imageView6,
            R.id.imageView7, R.id.imageView8, R.id.imageView9
    };
    private int[] audioIds = {
            R.raw.a1, R.raw.a2, R.raw.a3,
            R.raw.a4, R.raw.a5, R.raw.a6,
            R.raw.a7, R.raw.a8, R.raw.a9
    };
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app11partie2);
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = findViewById(imageIds[i]);
            final int audioId = audioIds[i];
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jouerAudio(audioId);
                }
            });
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void jouerAudio(int audioId) {

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }


        mediaPlayer = MediaPlayer.create(this, audioId);
        mediaPlayer.start();


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                mediaPlayer = null;
            }
        });
    }
}
