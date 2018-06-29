package com.example.deakyu.fitnessapp.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.deakyu.fitnessapp.calorie.diet.model.DietLocal
import com.example.deakyu.fitnessapp.calorie.diet.model.MealLocal
import com.example.deakyu.fitnessapp.persistence.dao.DietDao
import com.example.deakyu.fitnessapp.persistence.dao.MealDao

@Database(entities = [(DietLocal::class), (MealLocal::class)], version = 1)
abstract class FitnessDatabase: RoomDatabase() {

    abstract fun dietDao(): DietDao
    abstract fun mealDao(): MealDao

    companion object {
        private var INSTANCE: FitnessDatabase ?= null

        fun getInstance(context: Context): FitnessDatabase? {
            if(INSTANCE == null) {
                synchronized(FitnessDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            FitnessDatabase::class.java, "fitness_db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}