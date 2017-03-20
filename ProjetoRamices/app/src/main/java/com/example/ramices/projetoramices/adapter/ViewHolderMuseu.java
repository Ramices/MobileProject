package com.example.ramices.projetoramices.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.ramices.projetoramices.R;

/**
 * Created by Ramices on 20/03/2017.
 */

public class ViewHolderMuseu
{
    final TextView nome;

    public ViewHolderMuseu(View view)
    {
        nome = (TextView) view.findViewById(R.id.txtnome);
    }
}
