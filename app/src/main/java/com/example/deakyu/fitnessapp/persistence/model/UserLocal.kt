package com.example.deakyu.fitnessapp.persistence.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class UserLocal(@PrimaryKey(autoGenerate = false) val id: String)