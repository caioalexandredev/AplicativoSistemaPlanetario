package com.example.tarefa5_14102025.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarefa5_14102025.R;
import com.example.tarefa5_14102025.model.ItemPlanetaLista;

import java.util.List;

public class ListaPlanetaAdapter extends RecyclerView.Adapter<ListaPlanetaAdapter.PlanetaViewHolder> {

    private Context context;
    private List<ItemPlanetaLista> listaPlanetas;
    private OnItemClickListener listener;

    public ListaPlanetaAdapter(Context context, List<ItemPlanetaLista> listaPlanetas, OnItemClickListener listener) {
        this.context = context;
        this.listaPlanetas = listaPlanetas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planeta_lista, parent, false);
        return new PlanetaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetaViewHolder holder, int position) {
        ItemPlanetaLista item = listaPlanetas.get(position);

        holder.textView.setText(item.getNome());
        holder.imageView.setImageResource(item.getImagem());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPlanetas.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ItemPlanetaLista item);
    }

    public static class PlanetaViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public PlanetaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewPlanetaItem);
            textView = itemView.findViewById(R.id.textViewPlanetaItem);
        }
    }
}