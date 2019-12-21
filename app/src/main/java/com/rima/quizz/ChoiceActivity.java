package com.rima.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChoiceActivity extends AppCompatActivity{
    TextView textQuestion;
    Button mathButton, pcButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        textQuestion = (TextView) findViewById(R.id.tvChoixMatiere);
        mathButton = (Button) findViewById(R.id.bMath);
        pcButton = (Button) findViewById(R.id.bPc);
        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuestion();
            }
        });
    }
    private void startQuestion()
    {
        QuestionActivity.scr1 = 0;
        QuestionActivity.scr2 = 0;
        QuestionActivity.NumQuestion=1;
        Intent intent = new Intent("com.rima.quizz.QUESTIONACTIVITY");
        startActivity(intent);

    }

}
