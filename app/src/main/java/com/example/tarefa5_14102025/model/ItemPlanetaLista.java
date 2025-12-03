package com.example.tarefa5_14102025.model;

import java.io.Serializable;

public class ItemPlanetaLista implements Serializable {
    private String nome;
    private int imagem;
    private Double gravidade;

    public ItemPlanetaLista(String nome, int imagem, Double gravidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.gravidade = gravidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Double getGravidade() {
        return gravidade;
    }

    public void setGravidade(double gravidade) {
        this.gravidade = gravidade;
    }
}