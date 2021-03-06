package com.hugoapp.data.repository

import com.hugoapp.core.interactor.repository.VehicleRepository
import com.hugoapp.data.db.dao.VehicleDao
import com.hugoapp.data.db.model.VehicleEntity
import com.hugoapp.data.db.model.VehicleModel
import com.hugoapp.data.util.EntityMapperHelper

class VehicleRepositoryImpl(
    private val dao: VehicleDao,
    private val mapperHelper: EntityMapperHelper
) : VehicleRepository {

    override suspend fun asyncCreateVehicle(vehicleModel: VehicleModel) =
        dao.insert(mapperHelper.vehicleModelToEntity(vehicleModel))

    override suspend fun asyncGetVehicleList(): List<VehicleModel> {
        val vehicleList: MutableList<VehicleModel> = mutableListOf()
        val data = dao.getVehicleList()
        data.forEach {
            vehicleList.add(it.mapToCoreModel())
        }
        return vehicleList
    }
}