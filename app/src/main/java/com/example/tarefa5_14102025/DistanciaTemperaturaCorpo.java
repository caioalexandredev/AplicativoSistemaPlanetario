package com.example.tarefa5_14102025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DistanciaTemperaturaCorpo extends AppCompatActivity {

    TextView textViewDistancia, textViewTemperatura;
    ImageView imageViewCorpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancia_temperatura_corpo);

        textViewDistancia = findViewById(R.id.textViewDistancia);
        textViewTemperatura = findViewById(R.id.textViewTemperatura);
        imageViewCorpo = findViewById(R.id.imageViewCorpo);

        Intent it = getIntent();

        String tipo = it.getStringExtra("tipo");

        if(tipo != null){
            if(tipo.equals("SOL")){
                imageViewCorpo.setImageResource(R.drawable.sun);
                textViewTemperatura.setText(R.string.temperatura_media_sol);
                textViewDistancia.setText(R.string.distancia_sol_terra);
            }else{
                imageViewCorpo.setImageResource(R.drawable.full_moon);
                textViewTemperatura.setText(R.string.temperatura_media_lua);
                textViewDistancia.setText(R.string.distancia_lua_terra);
            }
        }

    }
}