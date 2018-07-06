package com.example.deakyu.fitnessapp.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.deakyu.fitnessapp.calorie.diet.model.DietLocal
import com.example.deakyu.fitnessapp.calorie.diet.model.MealLocal
import com.example.deakyu.fitnessapp.persistence.dao.*
import com.example.deakyu.fitnessapp.persistence.model.ConsumableLocal
import com.example.deakyu.fitnessapp.persistence.model.ConsumableMealJoin
import com.example.deakyu.fitnessapp.persistence.model.DailyCalory
import com.example.deakyu.fitnessapp.persistence.model.UserLocal

@Database(entities = [UserLocal::class,
                      DailyCalory::class,
                      DietLocal::class,
                      MealLocal::class,
                      ConsumableLocal::class,
                      ConsumableMealJoin::class], version = 1)
@TypeConverters(Converters::class)
abstract class FitnessDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun dietDao(): DietDao
    abstract fun mealDao(): MealDao
    abstract fun consumableDao(): ConsumableDao
    abstract fun dailyCaloryDao(): DailyCaloryDao
    abstract fun consumableMealJoinDao(): ConsumableMealJoinDao

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