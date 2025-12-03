package com.example.tarefa5_14102025;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.tarefa5_14102025.respository.PlanetaRepository;

import java.util.List;

public class ListaPlanetaFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;
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
        List<ItemPlanetaLista> itens = PlanetaRepository.all();
        adapter = new ListaPlanetaAdapter(getContext(), itens);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemPlanetaLista itemSelecionado = (ItemPlanetaLista) parent.getItemAtPosition(position);

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