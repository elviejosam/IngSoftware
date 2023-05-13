package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoMusical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_musical);

        VideoView video_musical = findViewById(R.id.video_musical);
        String videoPath = "android.resource://" + getPackageName() +"/" +R.raw.song;
        Uri uri = Uri.parse(videoPath);
        video_musical.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video_musical.setMediaController(mediaController);
        mediaController.setAnchorView(video_musical);
    }
}