package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoDibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_dibujo);

        VideoView video_draw = findViewById(R.id.video_draw);
        String videoPath = "android.resource://" + getPackageName() +"/" +R.raw.dibujo;
        Uri uri = Uri.parse(videoPath);
        video_draw.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video_draw.setMediaController(mediaController);
        mediaController.setAnchorView(video_draw);
    }
}