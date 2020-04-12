package com.hugoapp.data.repository

import android.util.Log
import com.hugoapp.core.interactor.repository.VehicleRepository
import com.hugoapp.data.db.dao.VehicleDao
import com.hugoapp.data.db.model.VehicleModel
import com.hugoapp.data.util.EntityMapperHelper

class VehicleRepositoryImpl(
    private val dao: VehicleDao,
    private val mapperHelper: EntityMapperHelper
) : VehicleRepository {

    override suspend fun asyncCreateVehicle(vehicleModel: VehicleModel) {
        Log.wtf("JAAC", "${vehicleModel.plateNumber} ${vehicleModel.type}")
        dao.insert(mapperHelper.vehicleModelToEntity(vehicleModel))
    }

    override suspend fun asyncGetVehicleList(): List<VehicleModel> {
        val vehicleList: MutableList<VehicleModel> = mutableListOf()
        val data = dao.getVehicleList()
        data.forEach {
            vehicleList.add(it.mapToCoreModel())
        }
        return vehicleList
    }

    override suspend fun asyncGetVehicleByPlate(plate: String): VehicleModel =
        dao.getVehicleByPlate(plate).mapToCoreModel()
}