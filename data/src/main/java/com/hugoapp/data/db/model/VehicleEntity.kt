package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugoapp.data.util.CoreMapper

@Entity
data class VehicleEntity(
    @PrimaryKey
    val plateNumber: String,
    val type: VehicleTypeModel
) : CoreMapper<VehicleModel> {
    override fun mapToCoreModel() = VehicleModel(
        plateNumber = this.plateNumber,
        type = this.type
    )
}