package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugoapp.data.util.CoreMapper

@Entity
data class MonthEntryLogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val vehiclePlateId: String,
    val entryDateTime: String,
    val exitDateTime: String? = null,
    val enable: Boolean = false
) : CoreMapper<MonthEntryLogModel> {
    override fun mapToCoreModel() = MonthEntryLogModel(
        id = this.id,
        vehiclePlateId = this.vehiclePlateId,
        entryDateTime = this.entryDateTime,
        exitDateTime = this.exitDateTime,
        enable = this.enable
    )
}


