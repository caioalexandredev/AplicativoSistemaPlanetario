package com.example.tarefa5_14102025.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CalculoPlaneta {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "massa")
    private Double massa;
    @ColumnInfo(name = "peso_calculado")
    private Double pesoCalculador;
    @ColumnInfo(name = "nome_planeta")
    private String nomePlaneta;

    public CalculoPlaneta() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMassa() {
        return massa;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }

    public Double getPesoCalculador() {
        return pesoCalculador;
    }

    public void setPesoCalculador(Double pesoCalculador) {
        this.pesoCalculador = pesoCalculador;
    }

    public String getNomePlaneta() {
        return nomePlaneta;
    }

    public void setNomePlaneta(String nomePlaneta) {
        this.nomePlaneta = nomePlaneta;
    }
}
