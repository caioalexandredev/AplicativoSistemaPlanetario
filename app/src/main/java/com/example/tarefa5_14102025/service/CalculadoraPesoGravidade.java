package com.example.tarefa5_14102025.service;

public class CalculadoraPesoGravidade {
    double massaKg;
    double gravidade;

    public CalculadoraPesoGravidade(double massaKg, double gravidade) {
        this.massaKg = massaKg;
        this.gravidade = gravidade;
    }

    public Double calcularPesoEmNewtons() {
        return this.massaKg * this.gravidade;
    }
}
