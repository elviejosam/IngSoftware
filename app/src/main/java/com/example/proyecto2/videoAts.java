package com.example.proyecto2;

import android.app.UiAutomation;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class videoAts extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoats);
        VideoView video_ats = findViewById(R.id.video_ats);
        String videoPath = "android.resource://" + getPackageName() +"/" +R.raw.ats;
        Uri uri = Uri.parse(videoPath);
        video_ats.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video_ats.setMediaController(mediaController);
        mediaController.setAnchorView(video_ats);
    }



}
