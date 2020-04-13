package com.hugoapp.core.interactor.repository

import com.hugoapp.data.db.model.MonthEntryLogModel
import com.hugoapp.data.db.model.VehicleModel

interface LogRepository {

    suspend fun createEntryLog(entryLogModel: MonthEntryLogModel)
}