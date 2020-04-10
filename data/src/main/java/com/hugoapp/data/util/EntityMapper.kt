package com.hugoapp.data.util

import com.hugoapp.data.db.model.VehicleEntity
import com.hugoapp.data.db.model.VehicleModel

// TODO: Looking for a best way to handle this mapper maybe with JSON

class EntityMapperHelper {
    fun vehicleModelToEntity(vehicleModel: VehicleModel) = VehicleEntity(
        plateNumber = vehicleModel.plateNumber,
        type = vehicleModel.type
    )
}