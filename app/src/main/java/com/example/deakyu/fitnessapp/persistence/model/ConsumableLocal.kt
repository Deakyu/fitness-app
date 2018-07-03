package com.example.deakyu.fitnessapp.persistence.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "consumables")
data class ConsumableLocal(@ColumnInfo(name = "calories") val calories: Double,
                           @ColumnInfo(name = "fat_grams") val fatGrams: Double,
                           @ColumnInfo(name = "saturated_grams") val saturedFatGrams: Double,
                           @ColumnInfo(name = "trans_fat_grams") val transFatGrams: Double,
                           @ColumnInfo(name = "polyunsaturated_fat_grams") val polyunsaturatedFatGrams: Double,
                           @ColumnInfo(name = "monounsaturated_fat_grams") val monounsaturatedFatGrams: Double,
                           @ColumnInfo(name = "carbohydrate_grams") val carbohydrateGrams: Double,
                           @ColumnInfo(name = "sugars_grams") val sugarsGrams: Double,
                           @ColumnInfo(name = "fiber_grams") val fiberGrams: Double,
                           @ColumnInfo(name = "protein_grams") val proteinGrams: Double,
                           @ColumnInfo(name = "product_name") val productName: String,
                           @ColumnInfo(name = "product_quantity") val productQuantity: Double,
                           @ColumnInfo(name = "image_url") val imageUrl: String,
                           @PrimaryKey(autoGenerate = false) val id: String)