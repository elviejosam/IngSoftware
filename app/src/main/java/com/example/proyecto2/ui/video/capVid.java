package com.example.proyecto2.ui.video;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyecto2.R;
import com.example.proyecto2.VideoDibujo;
import com.example.proyecto2.VideoMath;
import com.example.proyecto2.VideoMusical;
import com.example.proyecto2.databinding.ActivityCapBinding;
import com.example.proyecto2.fotito;
import com.example.proyecto2.videoAts;

public class capVid extends Fragment {

    private ActivityCapBinding binding;

    AppCompatImageButton imageButton1;
    AppCompatImageButton imageButton2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        videoModel viewModel =
                new ViewModelProvider(this).get(videoModel.class);

        binding = ActivityCapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View view = inflater.inflate(R.layout.videoats, container,false);

        imageButton1 = root.findViewById(R.id.imageButton);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), videoAts.class);
                startActivity(intent);
            }
        });

        imageButton2 = root.findViewById(R.id.imageButton2);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoMath.class);
                startActivity(intent);
            }
        });

        AppCompatImageButton imageButton3 = root.findViewById(R.id.imageButton3);

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoDibujo.class);
                startActivity(intent);
            }
        });

        AppCompatImageButton imageButton4 = root.findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoMusical.class);
                startActivity(intent);
            }
        });

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}