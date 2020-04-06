package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugoapp.data.util.CoreMapper

@Entity
data class VehicleEntity(
    @PrimaryKey
    val plateNumber: String,
    val vehicleTypeId: Int
) : CoreMapper<VehicleModel> {
    override fun mapToCoreModel() = VehicleModel(
        plateNumber = this.plateNumber,
        vehicleTypeId = this.vehicleTypeId
    )
}