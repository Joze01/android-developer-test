package com.hugoapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hugoapp.data.db.dao.LogDao
import com.hugoapp.data.db.dao.VehicleDao
import com.hugoapp.data.db.dao.VehicleTypeDao
import com.hugoapp.data.db.model.MonthEntryLogEntity
import com.hugoapp.data.db.model.VehicleEntity
import com.hugoapp.data.db.model.VehicleTypeEntity
import com.hugoapp.data.db.util.Converters

/**
 * Created by Jose Arteaga on 2019-10-27.
 * Applaudo Studios
 *
 * Main database description.
 */
@Database(
    entities = [
        MonthEntryLogEntity::class,
        VehicleEntity::class,
        VehicleTypeEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDb : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao
    abstract fun vehicleTypeDao(): VehicleTypeDao
    abstract fun logDao(): LogDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDb::class.java,
                "AppDb.db"
            ).build()
    }
}