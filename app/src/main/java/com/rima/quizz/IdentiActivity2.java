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
public class IdentiActivity2 extends AppCompatActivity{



    TextView textJoueur2;
    EditText userName2;
    Button Btn_annuler2, Btn_valider2;
    public static String prenom2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identi2);
        textJoueur2 = (TextView) findViewById(R.id.tvJoeur);
        userName2 = (EditText) findViewById(R.id.edUsername);
        Btn_annuler2 = (Button) findViewById(R.id.bOk);
        Btn_valider2 = (Button) findViewById(R.id.bValider);
        textJoueur2.setText("Prenom du joeur " + IdentiActivity.numJoueur );
        final int numJoueur2 =  IdentiActivity.numJoueur;
        userName2.requestFocus();
        Btn_valider2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IdentiActivity2.this, "Vous devez vous identifier pour pouvoir jouer", Toast.LENGTH_SHORT).show();
                String name2 = userName2.getText().toString();
                if( name2.equals(""))
                {
                    return;
                }
                else if(IdentiActivity.prenom1.equals(name2))
                {
                    Toast.makeText(IdentiActivity2.this, "Saisir un nom different de celui du joueur 1", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(IdentiActivity2.this, "Identification du joeur "+ numJoueur2 + " reussi", Toast.LENGTH_SHORT).show();
                prenom2= userName2.getText().toString();
                startChoice();
            }
        });
        Btn_annuler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revenirSurMain();
            }
        });
        IdentiActivity.numJoueur = 1;
    }

    private void startChoice()
    {
        Intent i2 = new Intent("com.rima.quizz.CHOICEACTIVITY");
        startActivity(i2);
    }
    private void revenirSurMain()
    {
        Intent i2 = new Intent("com.rima.quizz.MainActivity");
        startActivity(i2);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
