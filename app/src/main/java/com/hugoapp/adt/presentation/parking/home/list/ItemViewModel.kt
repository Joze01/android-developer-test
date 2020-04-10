package com.hugoapp.adt.presentation.parking.home.list

import androidx.databinding.ObservableField
import com.hugoapp.data.db.model.VehicleModel

class ItemViewModel(vehicleModel: VehicleModel) {
    val plateObservableField = ObservableField("")
    val typeName = ObservableField("")

    init {
        plateObservableField.set(vehicleModel.plateNumber)
        typeName.set(vehicleModel.type.typeName)
    }
}