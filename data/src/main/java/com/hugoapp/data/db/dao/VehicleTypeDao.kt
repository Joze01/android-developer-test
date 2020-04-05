package com.hugoapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hugoapp.data.db.model.VehicleEntity
import com.hugoapp.data.db.model.VehicleTypeEntity

@Dao
interface VehicleTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vehicle: VehicleTypeEntity)

    @Query("SELECT * FROM VehicleEntity LIMIT 1")
    suspend fun getVehicleTypes(): List<VehicleTypeEntity>
}