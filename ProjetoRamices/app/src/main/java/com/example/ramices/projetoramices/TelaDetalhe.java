package com.example.ramices.projetoramices;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramices.projetoramices.base.Museu;
import com.example.ramices.projetoramices.base.Teatro;

/**
 * Created by Ramices on 06/03/2017.
 */

public class TelaDetalhe extends AppCompatActivity {

    private TextView nome;
    private TextView descricao;
    private TextView bairro;
    private TextView logradouro;
    private TextView telefone;
    private TextView site;


    @Override
    public void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_tela_detalhe);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.menu_voltar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#8A2BE2")));

        nome = (TextView) findViewById(R.id.txtNomeD);
        descricao = (TextView) findViewById(R.id.txtDescricaoD);
        site = (TextView)findViewById(R.id.txtSiteD);
        bairro = (TextView) findViewById(R.id.txtBairroD);
        logradouro = (TextView)findViewById(R.id.txtLogradouroD);
        telefone = (TextView) findViewById(R.id.txtTelefoneD);

        switch (getIntent().getStringExtra("key").toString())
        {
            case "museu":
                Museu museu = (Museu)getIntent().getSerializableExtra("museu");
                nome.setText("Nome: " + museu.getNome());
                descricao.setText("Descricao: " +museu.getDescricao());
                bairro.setText("Bairro: " +museu.getBairro());
                logradouro.setText("Logradouro: " +museu.getLogradouro());
                telefone.setText("Telefone: " +museu.getTelefone());
                site.setText("Site: " + museu.getSite());

                break;

            case "teatro":
                Teatro teatro = (Teatro)getIntent().getSerializableExtra("teatro");

                nome.setText("Nome: " + teatro.getNome());
                descricao.setText("Descricao: " +teatro.getDescricao());
                bairro.setText("Bairro: " +teatro.getBairro());
                logradouro.setText("Logradouro: " +teatro.getLogradouro());
                telefone.setText("Telefone: " +teatro.getTelefone());
                site.setText("Site: " +"-");

                break;

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu)
    {
        switch (menu.getItemId())
        {

            case android.R.id.home:
                finish();
                break;

        }

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TelaDetalhe", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TelaDetalhe", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TelaDetalhe", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TelaDetalhe", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TelaDetalhe", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TelaDetalhe", "onDetroy");
    }
}
