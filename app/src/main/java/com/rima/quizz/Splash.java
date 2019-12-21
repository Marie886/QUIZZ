package com.rima.quizz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Splash extends AppCompatActivity {
    MediaPlayer splash_sound;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        splash_sound = MediaPlayer.create(getApplicationContext(), R.raw.musique_acceuil);
        splash_sound.start();
        Thread chrono = new Thread(){
            public void run(){
                try {
                    sleep(1000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent("com.rima.quizz.MAINACTIVITY");
                    startActivity(i);
                }
            }
        };
        chrono.start();
    }

    @Override
    protected void onPause() {
        splash_sound.release();
        super.onPause();
        finish();
    }
}

