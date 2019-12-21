package com.rima.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private TextView mScoreView;
    //private TextView mMatiereView;
    private TextView mQuestionView;
    private TextView mNumQuestion;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private static int min;
    private String mAnswer;
    public static int mQuestionNumber = 1;
    public  static int scr1=0;
    public  static int scr2=0;
    private static int   q=0;
    public static int NumQuestion = 1;
    private Button mReponse;
    private  ScoresHelper helper;
    private TextView player;
    public static int idPlayer = 1;
    int joker1=2;
    int joker2=2;
    private ProgressBar progression;
    private int ProgressBar=100/10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mScoreView = (TextView) findViewById(R.id.tvScore);
        mQuestionView = (TextView) findViewById(R.id.tvQuestion);
        mButtonChoice1 = (Button) findViewById(R.id.bChoice1);
        mButtonChoice2 = (Button) findViewById(R.id.bChoice2);
        mButtonChoice3 = (Button) findViewById(R.id.bChoice3);
        mNumQuestion = (TextView) findViewById(R.id.tvNumQuestion);
        mReponse = (Button) findViewById(R.id.bReponse);
        player = (TextView) findViewById(R.id.tvPlayer);
        progression = (ProgressBar) findViewById(R.id.progressBar);

        UpdateQuestion();

            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v1) {
                    mReponse.setText("Reponse");
                    if (mButtonChoice1.getText() == mAnswer) {

                        Toast.makeText(QuestionActivity.this, "Bonne reponse", Toast.LENGTH_SHORT).show();
                        progression.incrementProgressBy(ProgressBar);
                        if (idPlayer == 2)
                        {
                            scr1 = scr1 + 2;
                            UpdateQuestion();
                            mScoreView.setText(" Score : " + String.valueOf(scr1) + "-" + String.valueOf(scr2));
                        }
                        else {
                            scr2 = scr2 + 2;
                            UpdateQuestion();
                            mScoreView.setText(" Score : " + String.valueOf(scr1) + "-" + String.valueOf(scr2));
                        }

                    } else {
                        Toast.makeText(QuestionActivity.this, "Mauvaise reponse ", Toast.LENGTH_SHORT).show();
                        UpdateQuestion();

                    }
                }
            });

            mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v2) {
                    mReponse.setText("Reponse");
                    if (mButtonChoice2.getText() == mAnswer) {

                        progression.incrementProgressBy(ProgressBar);
                        Toast.makeText(QuestionActivity.this, "Bonne reponse", Toast.LENGTH_SHORT).show();
                        if (idPlayer == 2)
                        {
                            scr1 = scr1 + 2;
                            UpdateQuestion();
                            mScoreView.setText(" Score : " + String.valueOf(scr1) + "-" + String.valueOf(scr2));
                        }
                        else {
                            scr2 = scr2 + 2;
                            UpdateQuestion();
                            mScoreView.setText(" Score : " + String.valueOf(scr1) + "-" + String.valueOf(scr2));
                        }


                    } else {
                        Toast.makeText(QuestionActivity.this, "Mauvaise reponse", Toast.LENGTH_SHORT).show();
                        UpdateQuestion();

                    }
                }
            });

            mButtonChoice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mReponse.setText("Reponse");
                    if (mButtonChoice3.getText() == mAnswer) {

                        progression.incrementProgressBy(ProgressBar);
                        Toast.makeText(QuestionActivity.this, "Bonne reponse", Toast.LENGTH_SHORT).show();
                        if (idPlayer == 2)
                        {
                            scr1 = scr1 + 2;
                            UpdateQuestion();
                            mScoreView.setText(" Score : " + String.valueOf(scr1) + "-" + String.valueOf(scr2));
                        }
                        else {
                            scr2 = scr2 + 2;
                            UpdateQuestion();
                            mScoreView.setText(" Score : " + String.valueOf(scr1) + "-" + String.valueOf(scr2));
                        }

                    } else {
                        Toast.makeText(QuestionActivity.this, "Mauvaise reponse", Toast.LENGTH_SHORT).show();
                        UpdateQuestion();

                    }
                }
            });

        mReponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startReponse();
            }
        });
        }

    public void   UpdateQuestion()
    {
        if(NumQuestion<=10)
        {
            mQuestionNumber = (int) (Math.random() * 25);

            mNumQuestion.setText("Question" + " " + NumQuestion + "/10");
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);


            if (idPlayer == 1 && NumQuestion <10)
            {
                player.setText("C'est a votre tour " +IdentiActivity.prenom1);
                idPlayer = 2;
                NumQuestion++;
            }
            else {
                player.setText("C'est a votre tour " +IdentiActivity2.prenom2);
                idPlayer = 1;
                NumQuestion++;
            }

        }

        else if (NumQuestion >10){
            NumQuestion=1;
            startGame();
        }

    }

    private void startGame()
    {

        Intent j=GameOverActivity.newIntent(QuestionActivity.this,0);
        startActivity(j);

    }

    private void startReponse()
    {
        if (idPlayer==2){
            if (joker1>=1){
                joker1--;
                mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
                scr1--;
                AlertDialog dialog=new AlertDialog.Builder(QuestionActivity.this).setTitle("La reponse est "+mAnswer)
                        .setNegativeButton("Ok",null)
                        .create();
                dialog.show();
            }
            else{
                AlertDialog dialog=new AlertDialog.Builder(QuestionActivity.this).setTitle("Vous avez epuisé le nombre de joker")
                        .setNegativeButton("Ok",null)
                        .create();
                dialog.show();
            }

        }
        else if (idPlayer==1){
            if (joker2>=1){
                joker2--;
                mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
                scr2--;
                AlertDialog dialog=new AlertDialog.Builder(QuestionActivity.this).setTitle("La reponse est "+mAnswer)
                        .setNegativeButton("Ok",null)
                        .create();
                dialog.show();
            }
            else{
                AlertDialog dialog=new AlertDialog.Builder(QuestionActivity.this).setTitle("Vous avez epuisé le nombre de joker")
                        .setNegativeButton("Ok",null)
                        .create();
                dialog.show();
            }

        }
    }
    protected void onPause() {
        super.onPause();
        finish();
    }

}
