package com.example.proyecto2.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyecto2.R;
import com.example.proyecto2.TwitterClient;
import com.example.proyecto2.databinding.FragmentGalleryBinding;
import com.example.proyecto2.databinding.FragmentSlideshowBinding;
import com.example.proyecto2.fotito;
import com.example.proyecto2.ui.gallery.GalleryViewModel;

import twitter4j.ResponseList;
import twitter4j.Status;

public class SlideshowFragment extends Fragment implements TwitterClient.OnTweetsLoadedListener {

    private TextView mTextView;
    private TwitterClient twitterClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        twitterClient = new TwitterClient();
        twitterClient.loadTweets("PlayStation", this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_twitter, container, false);
        mTextView = root.findViewById(R.id.text_view);
        return root;
    }

    @Override
    public void onTweetsLoaded(ResponseList<Status> tweets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Status tweet : tweets) {
            stringBuilder.append("@" + tweet.getUser().getScreenName() + " - " + tweet.getText() + "\n\n");
        }
        if (mTextView != null) {
            mTextView.setText(stringBuilder.toString());
        }
    }
}
