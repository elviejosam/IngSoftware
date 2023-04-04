package com.example.proyecto2;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



public class TwitterClient {
    private static final String CONSUMER_KEY = "IfKtpBuDOVnVo0hY8XiMaJ5oe";
    private static final String CONSUMER_SECRET = "9WU2gjBwYjfK65yedkq0pbx7az1ukBptnNWkct15zUYcD6Oda6";
    private static final String ACCESS_TOKEN = "1643002896613515265-dQmZFhb6OS4aIj2jnFNC0awyrZBfQ3";
    private static final String ACCESS_TOKEN_SECRET = "C8572YcUSZnh89Cr2pibItATlAnzyrgtyR6SH0xZwNgdh";
    private static final int NUM_TWEETS = 10;

    private Twitter mTwitter;

    public interface OnTweetsLoadedListener {
        void onTweetsLoaded(ResponseList<Status> tweets);
    }

    public TwitterClient() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        TwitterFactory tf = new TwitterFactory(cb.build());
        mTwitter = tf.getInstance();
    }

    public void loadTweets(String username, OnTweetsLoadedListener listener) {
        new AsyncTask<String, Void, ResponseList<Status>>() {
            @Override
            protected ResponseList<twitter4j.Status> doInBackground(String... strings) {
                ResponseList<twitter4j.Status> tweets = null;
                try {
                    tweets = mTwitter.getUserTimeline(strings[0], new Paging(1, NUM_TWEETS));
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
                return tweets;
            }

            @Override
            protected void onPostExecute(ResponseList<twitter4j.Status> tweets) {
                if (listener != null) {
                    listener.onTweetsLoaded(tweets);
                }
            }
        }.execute(username);
    }

}
