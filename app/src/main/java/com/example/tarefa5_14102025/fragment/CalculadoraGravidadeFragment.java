package com.example.tarefa5_14102025.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tarefa5_14102025.CalculadoraPesoGravidade;
import com.example.tarefa5_14102025.model.ItemPlanetaLista;
import com.example.tarefa5_14102025.R;

public class CalculadoraGravidadeFragment extends Fragment {

    private ItemPlanetaLista item;
    private TextView textViewPlanetaActivity, textViewPlanetaGravidadeActivity, textViewResultado;
    private ImageView imageViewPlanetaActivity;
    private EditText editTextPeso;
    private Button buttonCalcularPeso;
    private ProgressBar progressBar;
    private int progress = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculadora, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewPlanetaGravidadeActivity = view.findViewById(R.id.textViewPlanetaGravidadeActivity);
        textViewPlanetaActivity = view.findViewById(R.id.textViewPlanetaActivity);
        imageViewPlanetaActivity = view.findViewById(R.id.imageViewPlanetaActivity);
        buttonCalcularPeso = view.findViewById(R.id.buttonCalcularPeso);
        textViewResultado = view.findViewById(R.id.textViewResultado);
        progressBar = view.findViewById(R.id.progressBar);
        editTextPeso = view.findViewById(R.id.editTextPeso);

        if (getArguments() != null) {
            item = (ItemPlanetaLista) getArguments().getSerializable("item");

            if (item != null) {
                imageViewPlanetaActivity.setImageResource(item.getImagem());
                textViewPlanetaActivity.setText(item.getNome());
                textViewPlanetaGravidadeActivity.setText(item.getGravidade().toString());
            }
        }

        buttonCalcularPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarProgressBar();
            }
        });
    }

    private void executarProgressBar() {
        progress = 0;
        progressBar.setProgress(progress);
        progressBar.setVisibility(View.VISIBLE);

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
                                if(!editTextPeso.getText().toString().isEmpty()){
                                    double massa = Double.parseDouble(editTextPeso.getText().toString());
                                    CalculadoraPesoGravidade calc = new CalculadoraPesoGravidade(massa, item.getGravidade());
                                    textViewResultado.setText("Peso: " + calc.calcularPesoEmNewtons() + " Newtons");
                                }
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