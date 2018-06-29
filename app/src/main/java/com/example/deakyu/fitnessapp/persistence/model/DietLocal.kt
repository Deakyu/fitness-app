package com.example.deakyu.fitnessapp.calorie.diet.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "diets")
data class DietLocal(@ColumnInfo(name = "diet_name") val dietName: Double,
                     @ColumnInfo(name = "meal_id") val mealId: String,
                     @PrimaryKey(autoGenerate = false) val id: String)
