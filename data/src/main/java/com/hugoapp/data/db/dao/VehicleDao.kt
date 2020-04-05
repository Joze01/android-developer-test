package com.hugoapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hugoapp.data.db.model.VehicleEntity

@Dao
interface VehicleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vehicle: VehicleEntity)

    @Query("SELECT * FROM VehicleEntity")
    suspend fun getVehicleList(): List<VehicleEntity>
}