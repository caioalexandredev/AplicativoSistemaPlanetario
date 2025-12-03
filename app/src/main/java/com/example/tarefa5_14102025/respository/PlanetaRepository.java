package com.example.tarefa5_14102025.respository;

import com.example.tarefa5_14102025.model.ItemPlanetaLista;
import com.example.tarefa5_14102025.R;

import java.util.ArrayList;
import java.util.List;

public class PlanetaRepository {
    public static List<ItemPlanetaLista> all(){
        List<ItemPlanetaLista> itens = new ArrayList<>();
        itens.add(new ItemPlanetaLista("Mercúrio", R.drawable.mercury, 3.7));
        itens.add(new ItemPlanetaLista("Vênus", R.drawable.venus, 8.87));
        itens.add(new ItemPlanetaLista("Terra", R.drawable.earth, 9.8));
        itens.add(new ItemPlanetaLista("Marte", R.drawable.mars, 3.711));
        itens.add(new ItemPlanetaLista("Júpiter", R.drawable.jupiter, 24.79));
        itens.add(new ItemPlanetaLista("Saturno", R.drawable.saturn, 10.44));
        itens.add(new ItemPlanetaLista("Urano", R.drawable.uranus, 8.69));
        itens.add(new ItemPlanetaLista("Netuno", R.drawable.neptune, 11.15));
        return itens;
    }
}
