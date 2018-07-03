package com.example.deakyu.fitnessapp.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.deakyu.fitnessapp.calorie.diet.model.MealLocal
import com.example.deakyu.fitnessapp.persistence.model.UserLocal

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<UserLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userLocal: UserLocal)

    @Query("DELETE FROM users")
    fun deleteAll()
}