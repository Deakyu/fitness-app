package com.example.deakyu.fitnessapp.calorie.diet.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "meals",
        foreignKeys = [ForeignKey(entity = DietLocal::class,
                                  parentColumns = ["id"],
                                  childColumns = ["dietId"],
                                  onDelete = CASCADE)])
data class MealLocal(@ColumnInfo(name = "dietId") val dietId: String,
                     @ColumnInfo(name = "mealName") val mealName: String,
                     @PrimaryKey(autoGenerate = false) val id: String)