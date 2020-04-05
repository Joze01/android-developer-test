package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class MonthEntryLogEntity(
    @PrimaryKey
    val id: Int,
    val vehiclePlateId: String,
    val entryDateTime: Date,
    val exitDateTime: Date? = null,
    val enable: Boolean = false
)


