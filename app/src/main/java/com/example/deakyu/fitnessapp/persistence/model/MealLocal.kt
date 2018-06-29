package com.example.deakyu.fitnessapp.calorie.diet.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "meals")
data class MealLocal(@ColumnInfo(name = "user_id") val userId: String,
                     @ColumnInfo(name = "meal_name") val mealName: String,
                     @PrimaryKey(autoGenerate = false) val mealId: String)
