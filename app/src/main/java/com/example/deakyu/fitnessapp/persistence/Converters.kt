package com.example.deakyu.fitnessapp.persistence

import android.arch.persistence.room.TypeConverter
import java.util.*

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: Long?) = if(value == null) null else Date()

    @TypeConverter
    @JvmStatic
    fun dateToTimestamp(date: Date?) = date?.time
}