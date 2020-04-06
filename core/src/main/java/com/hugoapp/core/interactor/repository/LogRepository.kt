package com.hugoapp.core.interactor.repository

import com.hugoapp.data.db.model.VehicleModel

interface LogRepository {

    suspend fun asyncCheckIn(vehicle: VehicleModel): Boolean
    suspend fun AsyncCheckOut(vehicle: VehicleModel): Double
    suspend fun AsyncgetMonthlyPayment()
}