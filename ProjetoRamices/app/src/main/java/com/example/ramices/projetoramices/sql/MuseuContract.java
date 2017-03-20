package com.example.ramices.projetoramices.sql;

import android.provider.BaseColumns;

/**
 * Created by Ramices on 15/03/2017.
 */

public interface MuseuContract extends BaseColumns {

    String TABLE_NAME = "museu";
    String ID = "id";
    String NOME = "nome";
    String DESCRICAO = "descricao";
    String BAIRRO = "bairro";
    String LOGRADOURO = "logradouro";
    String TELEFONE = "telefone";
    String LATITUDE = "latitude";
    String LONGITUDE = "longitude";
    String SITE = "site";
}
