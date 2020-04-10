package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class MonthEntryLogModel(
    @PrimaryKey
    val id: Int,
    val vehicle: VehicleModel,
    val entryDateTime: String,
    val exitDateTime: String? = null,
    val enable: Boolean = false
)


