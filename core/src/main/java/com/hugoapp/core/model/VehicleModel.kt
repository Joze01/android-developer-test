package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VehicleModel(
    @PrimaryKey
    val plateNumber: String,
    val vehicleTypeId: Int
)