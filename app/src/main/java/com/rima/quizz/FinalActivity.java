package com.rima.quizz;

import android.content.Context;
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

public class FinalActivity extends AppCompatActivity {
    private ListView listview;
    private  ScoresHelper helper;
    private  int scr1 = 0;
    private   int scr2 = 0;
    private  int min = 0;
    private Button buttonRetourner;
    private static String key="Responses" ;
    public static Intent newIntent(Context packageContext, int reponse ){
        Intent j = new Intent(packageContext , FinalActivity.class) ;
        j.putExtra(key , reponse) ;

        return  j ;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        listview= (ListView) findViewById(R.id.listescore);
        helper=new ScoresHelper(this);
        scr1= QuestionActivity.scr1;
        scr2= QuestionActivity.scr2;
        min=helper.minTop5();
        if (scr1!=0 && scr2!=0) {
            if (scr1 > scr2) {
                if (scr1 > min) {

                    String name = IdentiActivity.prenom1;
                    helper.insertNameAndScore(name, scr1);

                }
            } else if (scr2 > scr1) {
                if (scr2 > min) {

                    String name = IdentiActivity2.prenom2;
                    helper.insertNameAndScore(name, scr2);
                }
            }
            else if(scr1 == scr2)
            {
                if (scr2 > min)
                {
                    String name1 = IdentiActivity.prenom1;
                    helper.insertNameAndScore(name1, scr1);
                    String name2 = IdentiActivity2.prenom2;
                    helper.insertNameAndScore(name2, scr2);
                }
            }
        }

        updateUI();

    }

    void updateUI(){
        helper.deleteMin();

        ArrayList<String> topscore= new ArrayList<>();

        topscore=helper.showScores();
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.score_adapter,R.id.item2,topscore);
        listview.setAdapter(adapter);
        // Toast.makeText(ScoreActivity.this, "affichage score",Toast.LENGTH_LONG).show();
        QuestionActivity.scr1= 0;
        QuestionActivity.scr2= 0;
    }


}

