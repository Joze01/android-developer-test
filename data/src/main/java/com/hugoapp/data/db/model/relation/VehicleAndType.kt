package com.hugoapp.data.db.model

import androidx.room.Embedded
import androidx.room.Relation

data class VehicleAndType(
    @Embedded val vehicleTypeEntity: VehicleTypeEntity,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "vehicleTypeId"
    )
    val vehicleEntity: VehicleEntity
)