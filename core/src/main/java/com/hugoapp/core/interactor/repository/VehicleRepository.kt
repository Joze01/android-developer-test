package com.hugoapp.core.interactor.repository

import androidx.lifecycle.LiveData
import com.hugoapp.core.util.Resource
import com.hugoapp.data.db.model.VehicleModel

interface VehicleRepository {
    suspend fun asyncCreateVehicle(vehicleModel: VehicleModel)

    suspend fun asyncGetVehicleList(): LiveData<Resource<ArrayList<VehicleModel>>>
}