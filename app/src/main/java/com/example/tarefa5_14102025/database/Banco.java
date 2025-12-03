package com.example.tarefa5_14102025.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tarefa5_14102025.model.CalculoPlaneta;
import com.example.tarefa5_14102025.model.dao.CalculoPlanetaDao;

@Database(entities = {CalculoPlaneta.class}, version = 1)
public abstract class Banco extends RoomDatabase {
    public abstract CalculoPlanetaDao calculoPlanetaDao();
}
