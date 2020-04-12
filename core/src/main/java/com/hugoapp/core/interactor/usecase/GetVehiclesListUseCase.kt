package com.hugoapp.core.interactor.usecase

import com.hugoapp.core.interactor.repository.VehicleRepository

class GetVehiclesListUseCase(private val vehicleRepository: VehicleRepository) {
    suspend operator fun invoke() = vehicleRepository.asyncGetVehicleList()
}