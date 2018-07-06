package com.example.deakyu.fitnessapp.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.deakyu.fitnessapp.persistence.model.DailyCalory

@Dao
interface DailyCaloryDao {
    @Query("SELECT * FROM daily_calories")
    fun getAllDiets(): LiveData<List<DailyCalory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dailyCalory: DailyCalory)

    @Query("DELETE FROM daily_calories")
    fun deleteAll()
}