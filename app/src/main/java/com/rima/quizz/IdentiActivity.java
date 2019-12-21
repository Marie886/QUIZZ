package com.rima.quizz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class IdentiActivity extends AppCompatActivity
{

TextView textJoueur;
    EditText userName;
    Button Btn_annuler, Btn_valider;
    public static int numJoueur = 1;
    public static String prenom1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identi);
        textJoueur = (TextView) findViewById(R.id.tvJoeur);
        userName = (EditText) findViewById(R.id.edUsername);
        Btn_annuler = (Button) findViewById(R.id.bOk);
        Btn_valider = (Button) findViewById(R.id.bValider);
        textJoueur.setText("Prenom du joeur " + numJoueur );
        userName.requestFocus();


        Btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IdentiActivity.this, "Vous devez vous identifier pour pouvoir jouer", Toast.LENGTH_SHORT).show();
                String name1 = userName.getText().toString();
                if( name1.equals(""))
                {
                    return;
                }
                Toast.makeText(IdentiActivity.this, "Identification du joeur "+ numJoueur + " reussi", Toast.LENGTH_SHORT).show();
                numJoueur++;
                prenom1= userName.getText().toString();
                startIdentification();
            }
        });
        Btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revenirSurMain();
            }
        });

    }
   private void startIdentification()
   {
        Intent intent = new Intent("com.rima.quizz.IDENTIACTIVITY2");
        startActivity(intent);
    }
    private void revenirSurMain()
    {
        Intent intent = new Intent("com.rima.quizz.MainActivity");
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
