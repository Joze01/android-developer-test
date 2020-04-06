package com.hugoapp.core.interactor.repository

import com.hugoapp.data.db.model.VehicleModel

interface VehicleRepository {
    suspend fun asyncCreateVehicle(vehicleModel: VehicleModel)

    suspend fun asyncGetVehicleList(): List<VehicleModel>?
}