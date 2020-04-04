package com.hugoapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Jose Arteaga on 2019-10-27.
 * Applaudo Studios
 *
 * Main database description.
 */
@Database(
    entities = [

    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDb::class.java,
                "AppDb.db"
            ).build()
    }
}