package com.poseidon.poseidon;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rafae on 25/09/2017.
 */

public class ListViewAdapter implements ListAdapter {
    List<Integer> imagens;
    List<String> nome;
    List<String> porcentagem;
    Context context;

    public ListViewAdapter(List<Integer> imagens, List<String> nome, List<String> porcentagem, Context context) {
        this.imagens = imagens;
        this.nome = nome;
        this.porcentagem = porcentagem;
        this.context = context;
    }

    public void setNome(List<String> nome) {
        this.nome = nome;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return nome.size();
    }

    @Override
    public String getItem(int position) {
        return nome.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(final int position, View x, ViewGroup parent) {
        if(x == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            x = inflater.inflate(R.layout.maquina_card, parent, false);
        }
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Grafico22Activity.class);
                i.putExtra("porcentagem", porcentagem.get(position));
                v.getContext().startActivity(i);
            }
        });
        LinearLayout iv_maquina = (LinearLayout) x.findViewById(R.id.iv_maquina);
        TextView tv_maquina_nome = (TextView) x.findViewById(R.id.tv_maquina_nome);
        TextView tv_maquina_porcentagem = (TextView) x.findViewById(R.id.tv_maquina_porcento);
        iv_maquina.setBackgroundColor(context.getResources().getColor(imagens.get(position)));
        tv_maquina_nome.setText(getItem(position));
        tv_maquina_porcentagem.setText(porcentagem.get(position));
        return x;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return nome.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
