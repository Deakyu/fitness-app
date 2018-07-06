package com.example.deakyu.fitnessapp.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.deakyu.fitnessapp.calorie.diet.model.MealLocal
import com.example.deakyu.fitnessapp.persistence.model.ConsumableLocal
import com.example.deakyu.fitnessapp.persistence.model.ConsumableMealJoin

@Dao
interface ConsumableMealJoinDao {
    @Insert
    fun insert(consumableMealJoin: ConsumableMealJoin)

    @Query("SELECT * FROM consumables INNER JOIN consumables_meals ON" +
            " consumables.id=consumables_meals.consumableId WHERE" +
            " consumables_meals.mealId=:mealId")
    fun getConsumablesByMealId(mealId: String): LiveData<List<ConsumableLocal>>

    @Query("SELECT * FROM meals INNER JOIN consumables_meals ON" +
            " meals.id=consumables_meals.mealId WHERE" +
            " consumables_meals.consumableId=:consumableId")
    fun getMealsByConsumableId(consumableId: String): LiveData<List<MealLocal>>
}