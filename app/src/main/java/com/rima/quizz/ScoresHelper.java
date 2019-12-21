package com.rima.quizz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ScoresHelper extends SQLiteOpenHelper {
    public  ScoresHelper(Context context){
        super(context,Scores.DB_NAME,null,Scores.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable=" CREATE TABLE " +   Scores.scoreEntre.TABLE
                + " ( " + Scores.scoreEntre._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  Scores.scoreEntre.Col_Joueur + " TEXT NOT NULL, "
                +  Scores.scoreEntre.Col_Point + " INTEGER NOT NULL ); " ;
        db.execSQL(createtable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<String> showScores(){

        // List<HashMap<String,String>> result=new ArrayList<>();
        String req=" SELECT * FROM " +Scores.scoreEntre.TABLE +" ORDER BY "+ Scores.scoreEntre.Col_Point + " DESC " ;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(req,null);
        // HashMap<String,String> List= new HashMap<>();
        ArrayList<String> result=new ArrayList<>();
        while (cursor.moveToNext()){

           /* List.put("Name ", cursor.getString(cursor.getColumnIndex(Scores.scoreEntre.Col_Joueur)));
            List.put("Score ", cursor.getString(cursor.getColumnIndex(Scores.scoreEntre.Col_Point)));
            result.add(List); */
            String r=cursor.getString(cursor.getColumnIndex(Scores.scoreEntre.Col_Joueur)) +"                   " +
                    "          "+
                    cursor.getString(cursor.getColumnIndex(Scores.scoreEntre.Col_Point))+" POINTS";
            result.add(r);


        }
       /* HashMap<String,String> List= new HashMap<>();
        List.put("Name","Keba");
        List.put("Score","25");
        List.put("Name","Modou");
        List.put("Score","20");
        result.add(List);*/
        System.out.print(result);


        return result;
    }
    public boolean insertNameAndScore(String nom,int score){
        long r;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Scores.scoreEntre.Col_Joueur,nom);
        values.put(Scores.scoreEntre.Col_Point,score);
        r=db.insert(Scores.scoreEntre.TABLE,null,values);
        if (r==-1)
        {
            return false;}
        db.close();
        return true;
    }

    public  void deleteMin(){
        SQLiteDatabase db=this.getWritableDatabase();
        String req=" DELETE FROM " +Scores.scoreEntre.TABLE + " WHERE "+ Scores.scoreEntre.Col_Point + " =( SELECT DISTINCT min( "
                +Scores.scoreEntre.Col_Point +" ) FROM "+ Scores.scoreEntre.TABLE +" ) AND ( SELECT COUNT(*) FROM "
                +Scores.scoreEntre.TABLE +" )>5 ";
        try {
            db.execSQL(req);
            System.out.println("Suppression effectuée");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(" Echec suppression ");
        }
    }

    public int minTop5() {
        SQLiteDatabase db = this.getReadableDatabase();
        this.deleteMin();
        // String re = " SELECT  MIN(" +Scores.scoreEntre.Col_Point +")  FROM  " + Scores.scoreEntre.TABLE;
        String req=" SELECT * FROM " +Scores.scoreEntre.TABLE +" ORDER BY "+ Scores.scoreEntre.Col_Point + " ASC " ;
        Cursor cursor = null;
        int min;
        cursor = db.rawQuery(req, null);
        if (cursor.moveToFirst()) {

            min = cursor.getInt(cursor.getColumnIndex(Scores.scoreEntre.Col_Point));
        }
        else{
            min = 0;}
        return min;
    }


}

