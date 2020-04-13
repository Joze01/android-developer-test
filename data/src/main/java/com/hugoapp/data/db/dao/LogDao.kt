package com.hugoapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hugoapp.data.db.model.MonthEntryLogEntity
import com.hugoapp.data.db.model.VehicleEntity

@Dao
interface LogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(logEntry: MonthEntryLogEntity)

    @Query("SELECT * FROM MonthEntryLogEntity")
    suspend fun getAllLog(): List<VehicleEntity>

    @Query("SELECT * FROM MonthEntryLogEntity WHERE vehicle Like :plate AND enable")
    suspend fun findVehicleByPlate(plate: String): List<VehicleEntity>

}