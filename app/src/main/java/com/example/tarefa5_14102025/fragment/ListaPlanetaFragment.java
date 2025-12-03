package com.example.tarefa5_14102025.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarefa5_14102025.model.ItemPlanetaLista;
import com.example.tarefa5_14102025.adapter.ListaPlanetaAdapter;
import com.example.tarefa5_14102025.R;
import com.example.tarefa5_14102025.respository.PlanetaRepository;

import java.util.List;

public class ListaPlanetaFragment extends Fragment {

    private RecyclerView listView;
    private ListaPlanetaAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_planeta, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listViewPlaneta);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ItemPlanetaLista> itens = PlanetaRepository.all();

        adapter = new ListaPlanetaAdapter(getContext(), itens, new ListaPlanetaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemPlanetaLista item) {
                onCLickPlaneta(item);
            }
        });

        listView.setAdapter(adapter);
    }

    public void onCLickPlaneta(ItemPlanetaLista itemSelecionado) {
        CalculadoraGravidadeFragment fragmentCalc = new CalculadoraGravidadeFragment();

        Bundle args = new Bundle();
        args.putSerializable("item", itemSelecionado);
        fragmentCalc.setArguments(args);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentCalc);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}