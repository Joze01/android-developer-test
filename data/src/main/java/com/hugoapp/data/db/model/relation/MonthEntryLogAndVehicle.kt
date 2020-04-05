package com.hugoapp.data.db.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.hugoapp.data.db.model.MonthEntryLogEntity
import com.hugoapp.data.db.model.VehicleEntity
import com.hugoapp.data.db.model.VehicleTypeEntity

class MonthEntryLogAndVehicle(
    @Embedded val vehicleEntity: VehicleEntity,
    @Relation(
        parentColumn = "plateNumber",
        entityColumn = "vehiclePlateId"
    )
    val MonthEntryLogEntity: MonthEntryLogEntity
)