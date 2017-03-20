package com.example.ramices.projetoramices.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ramices.projetoramices.R;
import com.example.ramices.projetoramices.base.Teatro;

import java.util.ArrayList;

/**
 * Created by Ramices on 27/10/2016.
 */

public class TeatroAdapter extends BaseAdapter
{
    private Activity act;
    private ArrayList<Teatro> teatros;
    private TextView nome;
    private TextView descricao;
    private TextView bairro;
    private TextView logradouro;
    private TextView telefone;

    public TeatroAdapter(Activity act, ArrayList<Teatro> teatros)
    {
        this.act = act;
        this.teatros = teatros;

    }

    @Override
    public int getCount()
    {
        return teatros.size();

    }

    @Override
    public Object getItem(int postition)
    {
        return  teatros.get(postition);

    }

    @Override
    public long getItemId(int position)
    {

        return 0;

    }

    @Override
    public View getView(int position, View recicleView, ViewGroup parent)
    {
        ViewHolderTeatro holder;
        View view;
        if(recicleView == null)
        {
            view = act.getLayoutInflater().inflate(R.layout.teatro_item_list, parent, false);
            holder = new ViewHolderTeatro(view);
            view.setTag(holder);
        }
        else
        {
            view = recicleView;
            holder = (ViewHolderTeatro) view.getTag();
        }

        Teatro teatro = teatros.get(position);
        holder.nome.setText(teatro.getNome());


        return view;

    }


}
