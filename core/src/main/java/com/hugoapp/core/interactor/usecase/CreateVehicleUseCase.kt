package com.hugoapp.core.interactor.usecase

import com.hugoapp.core.interactor.repository.VehicleRepository
import com.hugoapp.data.db.model.VehicleModel

class CreateVehicleUseCase(private val vehicleRepository: VehicleRepository) {
    suspend operator fun invoke(vehicleModel: VehicleModel) =
        vehicleRepository.asyncCreateVehicle(vehicleModel)
}