package com.example.deakyu.fitnessapp.persistence.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import com.example.deakyu.fitnessapp.calorie.diet.model.MealLocal

@Entity(tableName = "consumables_meals",
        primaryKeys = ["consumableId", "mealId"],
        foreignKeys = [
            ForeignKey(entity = ConsumableLocal::class,
                       parentColumns = ["id"],
                       childColumns = ["consumableId"]),
            ForeignKey(entity = MealLocal::class,
                       parentColumns = ["id"],
                       childColumns = ["mealId"])
        ])
data class ConsumableMealJoin(@ColumnInfo(name = "consumableId") val consumableId: String,
                              @ColumnInfo(name = "mealId") val mealId: String)