package com.hugoapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hugoapp.data.util.CoreMapper

@Entity
data class VehicleTypeEntity(
    @PrimaryKey(autoGenerate = true)
    val typeId: Int,
    val typeName: String,
    val typeDescription: String? = null,
    val isPaymentRequired: Boolean = true,
    val farePerMinute: Double = 0.0


) : CoreMapper<VehicleTypeModel> {
    override fun mapToCoreModel() = VehicleTypeModel(
        typeId = this.typeId,
        typeName = this.typeName,
        typeDescription = this.typeDescription,
        isPaymentRequired = this.isPaymentRequired,
        farePerMinute = this.farePerMinute
    )
}