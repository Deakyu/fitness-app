package com.example.deakyu.fitnessapp.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.deakyu.fitnessapp.calorie.diet.model.MealLocal

@Dao
interface MealDao {
    @Query("SELECT * FROM meals")
    fun getAllMeals(): LiveData<List<MealLocal>>

    @Query("SELECT * FROM meals WHERE dietId =:dietId")
    fun getMealsByDietId(dietId: String): LiveData<List<MealLocal>>

    @Insert(onConflict = REPLACE)
    fun insert(mealLocal: MealLocal)

    @Query("DELETE FROM meals")
    fun deleteAll()
}