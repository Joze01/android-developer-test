package com.hugoapp.data.repository

import com.hugoapp.core.interactor.repository.LogRepository
import com.hugoapp.data.db.dao.LogDao
import com.hugoapp.data.db.model.MonthEntryLogModel

class LogRepositoryImpl(val logDao: LogDao) : LogRepository {
    override suspend fun createEntryLog(entryLogModel: MonthEntryLogModel) {
    }
}