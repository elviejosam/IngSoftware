package com.example.proyecto2.ui.gallery;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.proyecto2.fotito;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;

import com.example.proyecto2.MainActivity;
import com.example.proyecto2.R;
import com.example.proyecto2.databinding.FragmentGalleryBinding;


public class GalleryFragment extends Fragment{
    Button btCamara;
    ImageView mirafoto;
    Uri image_uri;
    private static final int PERMISSION_CODE = 1000;
    private static final int capturar_imagen = 1001;

    private FragmentGalleryBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        btCamara = root.findViewById(R.id.btCamara);
        View view = inflater.inflate(R.layout.fragment_gallery, container,false);

        btCamara = view.findViewById(R.id.btCamara);

        btCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), fotito.class);
                startActivity(intent);
            }
        });

        //final TextView textView = binding.textGallery;
       // galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}