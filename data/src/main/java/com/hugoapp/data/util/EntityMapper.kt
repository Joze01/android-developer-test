package com.hugoapp.data.util

import com.hugoapp.data.db.model.VehicleEntity
import com.hugoapp.data.db.model.VehicleModel

class EntityMapperHelper {
    fun vehicleModelToEntity(vehicleModel: VehicleModel) = VehicleEntity(
        plateNumber = vehicleModel.plateNumber,
        type = vehicleModel.type
    )
}