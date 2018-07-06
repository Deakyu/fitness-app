package com.example.deakyu.fitnessapp.persistence.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "daily_calories",
        foreignKeys = [ForeignKey(entity = UserLocal::class,
                                  parentColumns = ["id"],
                                  childColumns = ["userId"],
                                  onDelete = CASCADE)])
data class DailyCalory(@ColumnInfo(name = "date") val date: Date,
                       @ColumnInfo(name = "eaten") val eaten: Double,
                       @ColumnInfo(name = "burned") val burned: Double,
                       @ColumnInfo(name = "userId") val userId: String,
                       @PrimaryKey(autoGenerate = false) val id: String)