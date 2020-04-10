package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugoapp.data.util.CoreMapper

@Entity
data class MonthEntryLogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val vehicle: VehicleModel,
    val entryDateTime: String,
    val exitDateTime: String? = null,
    val enable: Boolean = false
) : CoreMapper<MonthEntryLogModel> {
    override fun mapToCoreModel() = MonthEntryLogModel(
        id = this.id,
        vehicle = this.vehicle,
        entryDateTime = this.entryDateTime,
        exitDateTime = this.exitDateTime,
        enable = this.enable
    )
}


