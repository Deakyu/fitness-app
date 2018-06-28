package com.example.deakyu.fitnessapp.calorie.diet.model

/**
 * Created by jesussalazar on 6/27/18.
 */

data class Consumable(val calories: Double,
                      val fatGrams: Double,
                      val saturedFatGrams: Double,
                      val transFatGrams: Double,
                      val polyunsaturatedFatGrams: Double,
                      val monounsaturatedFatGrams: Double,
                      val carbohydrateGrams: Double,
                      val sugarsGrams: Double,
                      val fiberGrams: Double,
                      val proteinGrams: Double,
                      val productId: Long)