package com.example.ramices.projetoramices.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.example.ramices.projetoramices.TelaDetalhe;
import com.example.ramices.projetoramices.adapter.TeatroAdapter;
import com.example.ramices.projetoramices.base.Teatro;
import com.example.ramices.projetoramices.sql.DataBase;


import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by Ramices on 27/10/2016.
 */

public class TeatroListFragment extends ListFragment implements Serializable
{
    private  ArrayList<Teatro> teatros;
    private TeatroAdapter adaptadorTeatro;
    private Teatro teatro;
    private Intent it;


    @Override
    public void onActivityCreated(Bundle saveInstanceState)
    {
        super.onActivityCreated(saveInstanceState);

        teatros = DataBase.getInstance(getActivity()).getTeatros();
        adaptadorTeatro = new TeatroAdapter(getActivity(), teatros);
        setListAdapter(adaptadorTeatro);

    }



    @Override
    public void onListItemClick(ListView listView, View view, int position, long id)
    {

        teatro = teatros.get(position);

        it = new Intent(getActivity(), TelaDetalhe.class);
        it.putExtra("key", "teatro");
        it.putExtra("teatro", teatro);
        startActivity(it);

    }





}