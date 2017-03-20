package com.example.ramices.projetoramices.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.example.ramices.projetoramices.TelaDetalhe;
import com.example.ramices.projetoramices.adapter.MuseuAdapter;
import com.example.ramices.projetoramices.base.Museu;
import com.example.ramices.projetoramices.sql.DataBase;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ramices on 27/10/2016.
 */

public class MuseuListFragment extends ListFragment implements Serializable
{

    private ArrayList<Museu> museus;
    private MuseuAdapter adaptador;
    private Museu museu;
    private Intent it;


    @Override
    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        super.onActivityCreated(bundle);

        museus = DataBase.getInstance(getActivity()).getMuseus();
        adaptador = new MuseuAdapter(getActivity(), museus);
        setListAdapter(adaptador);


    }



    @Override
    public void onListItemClick(ListView listView, View view, int position, long id)
    {

        museu = museus.get(position);

        it = new Intent(getActivity(), TelaDetalhe.class);
        it.putExtra("key", "museu");
        it.putExtra("museu", museu);
        startActivity(it);

    }


}
