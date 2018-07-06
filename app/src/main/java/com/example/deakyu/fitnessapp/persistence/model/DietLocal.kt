package com.example.deakyu.fitnessapp.calorie.diet.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import com.example.deakyu.fitnessapp.persistence.model.UserLocal

@Entity(tableName = "diets",
        foreignKeys = [ForeignKey(entity = UserLocal::class,
                                  parentColumns = ["id"],
                                  childColumns = ["userId"],
                                  onDelete = CASCADE)])
data class DietLocal(@ColumnInfo(name = "dietName") val dietName: Double,
                     @ColumnInfo(name = "userId") val userId: String,
                     @PrimaryKey(autoGenerate = false) val id: String)
