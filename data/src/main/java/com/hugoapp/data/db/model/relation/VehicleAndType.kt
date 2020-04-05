package com.hugoapp.data.db.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.hugoapp.data.db.model.VehicleEntity
import com.hugoapp.data.db.model.VehicleTypeEntity

data class VehicleAndType(
    @Embedded val vehicleTypeEntity: VehicleTypeEntity,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "vehicleTypeId"
    )
    val vehicleEntity: VehicleEntity
)