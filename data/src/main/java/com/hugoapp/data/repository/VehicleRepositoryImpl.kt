package com.hugoapp.data.repository

import androidx.lifecycle.LiveData
import com.hugoapp.core.interactor.repository.VehicleRepository
import com.hugoapp.core.util.Resource
import com.hugoapp.data.db.dao.VehicleDao
import com.hugoapp.data.db.model.VehicleModel
import com.hugoapp.data.util.EntityMapperHelper
import com.hugoapp.data.util.NetworkBoundResource

class VehicleRepositoryImpl(
    private val dao: VehicleDao,
    private val mapperHelper: EntityMapperHelper
) : VehicleRepository {

    override suspend fun asyncCreateVehicle(vehicleModel: VehicleModel) {
        dao.insert(mapperHelper.vehicleModelToEntity(vehicleModel))
    }

    override suspend fun asyncGetVehicleList(): LiveData<Resource<ArrayList<VehicleModel>>> {
        return object :
            NetworkBoundResource<ArrayList<VehicleModel>>() {
            override suspend fun loadFromDb(): ArrayList<VehicleModel> {
                val resultList: ArrayList<VehicleModel> = arrayListOf()
                dao.getVehicleList().forEach {
                    resultList.add(it.mapToCoreModel())
                }
                return resultList
            }

        }.build().asLiveData()
    }
}
