package com.rima.quizz;

import android.provider.BaseColumns;

public class Scores {
    public static final String DB_NAME="scores.db";
    public  static  final  int DB_VERSION=1;

    public  class scoreEntre implements BaseColumns {
        public static  final  String TABLE="Scores";
        public static final  String Col_Point="POINT";
        public  static  final  String Col_Joueur="JOUEUR";

    }
}
