package com.example.tarefa5_14102025;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculadoraGravidadeActivity extends AppCompatActivity {
    private ItemPlanetaLista item;

    private TextView textViewPlanetaActivity, textViewPlanetaGravidadeActivity, textViewResultado;
    private ImageView imageViewPlanetaActivity;
    private EditText editTextPeso;
    private Button buttonCalcularPeso;
    private ProgressBar progressBar;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_gravidade);

        textViewPlanetaGravidadeActivity = findViewById(R.id.textViewPlanetaGravidadeActivity);
        textViewPlanetaActivity = findViewById(R.id.textViewPlanetaActivity);
        imageViewPlanetaActivity = findViewById(R.id.imageViewPlanetaActivity);
        buttonCalcularPeso = findViewById(R.id.buttonCalcularPeso);
        textViewResultado = findViewById(R.id.textViewResultado);
        progressBar = findViewById(R.id.progressBar);
        editTextPeso = findViewById(R.id.editTextPeso);

        Intent it = getIntent();
        item = it.getSerializableExtra("item", ItemPlanetaLista.class);

        imageViewPlanetaActivity.setImageResource(item.getImagem());
        textViewPlanetaActivity.setText(item.getNome());
        textViewPlanetaGravidadeActivity.setText(item.getGravidade().toString());

        buttonCalcularPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarProgressBar();
            }
        });

    }

    private void executarProgressBar() {
        progressBar.setProgress(progress);
        progressBar.setVisibility(TextView.VISIBLE);
        Handler handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progress < 100)  {
                    progress += 10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                            if(progress >= 100) {
                                double massa = Double.parseDouble(editTextPeso.getText().toString());
                                CalculadoraPesoGravidade calc = new CalculadoraPesoGravidade(massa, item.getGravidade());
                                textViewResultado.setText("Peso: " + calc.calcularPesoEmNewtons() + " Newtons");
                            }
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}