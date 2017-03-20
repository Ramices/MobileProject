package com.example.ramices.projetoramices.sql;

import android.provider.BaseColumns;

/**
 * Created by Ramices on 12/03/2017.
 */

public interface TeatroContract extends BaseColumns {

    String TABLE_NAME = "teatro";
    String ID = "id";
    String NOME = "nome";
    String DESCRICAO = "descricao";
    String BAIRRO = "bairro";
    String LOGRADOURO = "logradouro";
    String TELEFONE = "telefone";
    String LATITUDE = "latitude";
    String LONGITUDE = "longitude";
}
