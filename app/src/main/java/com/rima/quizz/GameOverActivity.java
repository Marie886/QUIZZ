package com.rima.quizz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameOverActivity extends AppCompatActivity {
   private Button buttonRejouer;
  private Button buttonRetour;
    private  int scr1 = 0;
    private   int scr2 = 0;
    private  ScoresHelper helper;
    private  int min;
    private static String key="Responses" ;
    public static Intent newIntent(Context packageContext, int reponse ){
        Intent j = new Intent(packageContext , GameOverActivity.class) ;
        j.putExtra(key , reponse) ;

        return  j ;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        buttonRetour = (Button) findViewById(R.id.bRetoure);
        buttonRejouer = (Button) findViewById(R.id.bRejoeur);
        helper=new ScoresHelper(this);
        scr1= QuestionActivity.scr1;
        scr2= QuestionActivity.scr2;
        min=helper.minTop5();

        //Toast.makeText(FinalActivity.this, "min="+min, Toast.LENGTH_LONG).show();
        if (scr1!=0 && scr2!=0) {
            if (scr1 > scr2) {
                //Toast.makeText(FinalActivity.this, "score 1= "+scr1, Toast.LENGTH_LONG).show();
                if (scr1 > min) {




                    AlertDialog alert = new AlertDialog.Builder(GameOverActivity.this).create();
                    alert.setTitle("Felicitation " + IdentiActivity.prenom1 );
                    alert.setMessage("Tu fais parti du top 5 \n Voulez-vous voir votre position par rapport au 5 meilleurs");
                    alert.setButton(AlertDialog.BUTTON_POSITIVE, "OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent j=FinalActivity.newIntent(GameOverActivity.this,0);
                            startActivity(j);
                        }
                    });
                    alert.setButton(AlertDialog.BUTTON_NEGATIVE, "NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alert.show();

                    buttonRetour.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.CHOICEACTIVITY");
                            startActivity(i2);
                        }
                    });
                    buttonRejouer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.QUESTIONACTIVITY");
                            startActivity(i2);
                        }
                    });


                } else if(scr1 <= min){
                    AlertDialog dialog = new AlertDialog.Builder(GameOverActivity.this)
                            .setTitle("Felicitation " + IdentiActivity.prenom1 + "tu as gagné")
                            .setNegativeButton("Ok", null)
                            .create();
                    dialog.show();

                    buttonRetour.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.CHOICEACTIVITY");
                            startActivity(i2);
                        }
                    });
                    buttonRejouer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.QUESTIONACTIVITY");
                            startActivity(i2);
                        }
                    });

                }
            } else if (scr2 > scr1) {
                if (scr2 > min) {
                    AlertDialog alert = new AlertDialog.Builder(GameOverActivity.this).create();
                    alert.setTitle("Felicitation " + IdentiActivity2.prenom2 );
                    alert.setMessage("Tu fais parti du top 5 \n Voulez-vous voir votre position par rapport au 5 meilleurs");
                    alert.setButton(AlertDialog.BUTTON_POSITIVE, "OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent j=FinalActivity.newIntent(GameOverActivity.this,0);
                            startActivity(j);
                        }
                    });
                    alert.setButton(AlertDialog.BUTTON_NEGATIVE, "NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alert.show();

                    buttonRetour.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.CHOICEACTIVITY");
                            startActivity(i2);
                        }
                    });
                    buttonRejouer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.QUESTIONACTIVITY");
                            startActivity(i2);
                        }
                    });



                } else  if(scr2 <= min){
                    AlertDialog dialog = new AlertDialog.Builder(GameOverActivity.this)
                            .setTitle("Felicitation " + IdentiActivity2.prenom2 + "tu as gagné")
                            .setNegativeButton("Ok", null)
                            .create();
                    dialog.show();

                    buttonRetour.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.CHOICEACTIVITY");
                            startActivity(i2);
                        }
                    });
                    buttonRejouer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            QuestionActivity.scr1 = 0;
                            QuestionActivity.scr2 = 0;
                            QuestionActivity.NumQuestion=1;
                            Intent i2 = new Intent("com.rima.quizz.QUESTIONACTIVITY");
                            startActivity(i2);
                        }
                    });

                }
            } else if(scr1 ==scr2){
                AlertDialog dialog = new AlertDialog.Builder(GameOverActivity.this)
                        .setTitle("Match nul")
                        .setNegativeButton("Ok", null)
                        .create();
                dialog.show();


                buttonRetour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        QuestionActivity.scr1 = 0;
                        QuestionActivity.scr2 = 0;
                        QuestionActivity.NumQuestion=1;
                        Intent i2 = new Intent("com.rima.quizz.CHOICEACTIVITY");
                        startActivity(i2);
                    }
                });
                buttonRejouer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        QuestionActivity.scr1 = 0;
                        QuestionActivity.scr2 = 0;
                        QuestionActivity.NumQuestion=1;
                        Intent i2 = new Intent("com.rima.quizz.QUESTIONACTIVITY");
                        startActivity(i2);
                    }
                });

            }
        }

    }
    protected void onPause() {
        super.onPause();
        finish();
    }

}

