package com.example.deakyu.fitnessapp.persistence.model

import android.arch.persistence.room.Entity

@Entity(tableName = "consumables")
data class ConsumableLocal(val calories: Double,
                           val fatGrams: Double,
                           val saturedFatGrams: Double,
                           val transFatGrams: Double,
                           val polyunsaturatedFatGrams: Double,
                           val monounsaturatedFatGrams: Double,
                           val carbohydrateGrams: Double,
                           val sugarsGrams: Double,
                           val fiberGrams: Double,
                           val proteinGrams: Double,
                           val productId: String)