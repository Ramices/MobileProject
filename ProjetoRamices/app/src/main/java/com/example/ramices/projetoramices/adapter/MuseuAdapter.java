package com.example.ramices.projetoramices.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ramices.projetoramices.R;
import com.example.ramices.projetoramices.base.Museu;

import java.util.ArrayList;

/**
 * Created by Ramices on 27/10/2016.
 */

public class MuseuAdapter extends BaseAdapter {

    private ArrayList<Museu> museus;
    private Activity act;

    public MuseuAdapter(Activity act, ArrayList<Museu> museus)
    {
        this.museus = museus;
        this.act = act;

    }

    @Override
    public int getCount()
    {

        return museus.size();

    }

    @Override
    public Object getItem(int position)
    {
        return museus.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;

    }

    @Override
    public View getView(int position, View recicleView, ViewGroup parent)
    {
        ViewHolderMuseu holder;
        View view;
        if(recicleView == null)
        {
            view = act.getLayoutInflater().inflate(R.layout.museu_item_list, parent, false);
            holder = new ViewHolderMuseu(view);
            view.setTag(holder);
        }
        else
        {
            view = recicleView;
           holder = (ViewHolderMuseu) view.getTag();
        }

        Museu museu = museus.get(position);

        holder.nome.setText(museu.getNome());


        return view;
    }






}
