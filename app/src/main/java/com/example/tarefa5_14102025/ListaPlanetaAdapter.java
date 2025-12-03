package com.example.tarefa5_14102025;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListaPlanetaAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ItemPlanetaLista> itens;

    public ListaPlanetaAdapter(Context context,List<ItemPlanetaLista> itens) {
        this.inflater = LayoutInflater.from(context);
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public ItemPlanetaLista getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_planeta_lista, parent, false);
        }

        ItemPlanetaLista item = getItem(position);

        TextView textView = convertView.findViewById(R.id.textViewPlanetaItem);
        textView.setText(item.getNome());

        ImageView imageView = convertView.findViewById(R.id.imageViewPlanetaItem);
        imageView.setImageResource(item.getImagem());

        return convertView;
    }
}