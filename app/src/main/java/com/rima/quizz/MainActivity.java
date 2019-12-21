package com.rima.quizz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textBienvenue;
    Button jouer, voirScore;
    String [] joueur = {"", ""};
    public static int numJoueur =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBienvenue = (TextView) findViewById(R.id.tvWelcome);
        jouer = (Button) findViewById(R.id.bPlay);
        voirScore = (Button) findViewById(R.id.bScore);
        voirScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent j=FinalActivity.newIntent(MainActivity.this,0);
                startActivity(j);


            }
        });
        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               startQuizz();

            }
        });
    }

   private void startQuizz()
    {
        Intent intent = new Intent("com.rima.quizz.IDENTIACTIVITY");
        startActivity(intent);
    }
}
