package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VehicleEntity(
    @PrimaryKey
    val plateNumber: String,
    val vehicleTypeId: Int,
    val isPaymentRequired: Boolean = true,
    val isLargeDuration: Boolean = false
)