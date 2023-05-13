package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoMath extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_math);

        VideoView video_math = findViewById(R.id.video_math);
        String videoPath = "android.resource://" + getPackageName() +"/" +R.raw.math;
        Uri uri = Uri.parse(videoPath);
        video_math.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video_math.setMediaController(mediaController);
        mediaController.setAnchorView(video_math);
    }
}