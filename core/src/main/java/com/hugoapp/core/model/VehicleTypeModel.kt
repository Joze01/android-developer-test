package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VehicleTypeModel(
    @PrimaryKey
    val typeId: Int,
    val typeName: String,
    val typeDescription: String? = null,
    val isPaymentRequired: Boolean = true,
    val isLargeDuration: Boolean = false
)