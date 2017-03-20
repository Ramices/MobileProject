package com.example.ramices.projetoramices.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.ramices.projetoramices.TelaPrincipal;
import com.example.ramices.projetoramices.base.Museu;
import com.example.ramices.projetoramices.base.Teatro;

import java.util.ArrayList;

/**
 * Created by Ramices on 12/03/2017.
 */

public class DbOpenHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "ramicesmoises.db";


    public DbOpenHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL("drop table if exists " + TeatroContract.TABLE_NAME + "; " +
                "CREATE TABLE " + TeatroContract.TABLE_NAME + "(" +
                TeatroContract.ID + " integer primary key autoincrement, " +
                TeatroContract.NOME + " text not null, " +
                TeatroContract.DESCRICAO + " text not null, " +
                TeatroContract.BAIRRO + " text not null, " +
                TeatroContract.LOGRADOURO + " text not null, " +
                TeatroContract.TELEFONE + " text not null, " +
                TeatroContract.LATITUDE + " double  not null, " +
                TeatroContract.LONGITUDE + " double   not null" + ")"

        );

        database.execSQL("drop table if exists " + MuseuContract.TABLE_NAME + "; " +
                "CREATE TABLE " + MuseuContract.TABLE_NAME + "(" +
                MuseuContract.ID + " integer primary key autoincrement, " +
                MuseuContract.NOME + " text  not null, " +
                MuseuContract.DESCRICAO + " text not null, " +
                MuseuContract.BAIRRO + " text not null, " +
                MuseuContract.LOGRADOURO + " text not null, " +
                MuseuContract.TELEFONE + " text not null, " +
                MuseuContract.LATITUDE + " double   not null, " +
                MuseuContract.LONGITUDE + " double   not null, " +
                MuseuContract.SITE + " text not null"  + ")"
        );


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


}
