package com.example.tarefa5_14102025;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Sistema Solar");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, new ListaPlanetaFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
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
}