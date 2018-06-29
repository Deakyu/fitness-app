package com.example.deakyu.fitnessapp.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.deakyu.fitnessapp.calorie.diet.model.DietLocal

interface DietDao {
    @Query("SELECT * FROM diets")
    fun getAllDiets(): LiveData<List<DietLocal>>

    @Insert(onConflict = REPLACE)
    fun insert(dietLocal: DietLocal)

    @Query("DELETE FROM diets")
    fun deleteAll()
}