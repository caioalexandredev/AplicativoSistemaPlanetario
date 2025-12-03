package com.example.tarefa5_14102025.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.tarefa5_14102025.model.CalculoPlaneta;

@Dao
public interface CalculoPlanetaDao {
    @Insert
    long adicionar(CalculoPlaneta c);
}