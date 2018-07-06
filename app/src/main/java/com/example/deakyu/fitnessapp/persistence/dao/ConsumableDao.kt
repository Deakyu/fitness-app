package com.example.deakyu.fitnessapp.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.deakyu.fitnessapp.persistence.model.ConsumableLocal

@Dao
interface ConsumableDao {
    @Query("SELECT * FROM consumables")
    fun getAllConsumables(): LiveData<List<ConsumableLocal>>

    @Insert(onConflict = REPLACE)
    fun insert(consumableLocal: ConsumableLocal)

    @Query("DELETE FROM consumables")
    fun deleteAll()
}
