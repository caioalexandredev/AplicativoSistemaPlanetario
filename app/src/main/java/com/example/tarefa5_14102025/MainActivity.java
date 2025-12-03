package com.example.tarefa5_14102025;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.tarefa5_14102025.respository.PlanetaRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ListaPlanetaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sistema Solar");
        listView = findViewById(R.id.listViewPlaneta);

        List<ItemPlanetaLista> itens = PlanetaRepository.all();
        adapter = new ListaPlanetaAdapter(MainActivity.this, itens);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(MainActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent it = null;
        if(R.id.sol == item.getItemId()){
            it= new Intent(getApplicationContext(), DistanciaTemperaturaCorpo.class);
            it.putExtra("tipo","SOL");
            startActivity(it);
            return true;
        }
        if(R.id.lua == item.getItemId()) {
            it = new Intent(getApplicationContext(), DistanciaTemperaturaCorpo.class);
            it.putExtra("tipo", "LUA");
            startActivity(it);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemPlanetaLista item = (ItemPlanetaLista) parent.getItemAtPosition(position);

        Intent it = new Intent(MainActivity.this, CalculadoraGravidadeActivity.class);
        it.putExtra("item", item);
        startActivity(it);
    }
}