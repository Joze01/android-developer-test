package com.hugoapp.adt.presentation.parking.vehicles.list

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.data.db.model.VehicleModel

class VehicleItemViewModel(
    val vehicleModel: VehicleModel,
    val clickEvent: MutableLiveData<Event<VehicleModel>>
) {
    val plateObservableField = ObservableField("")
    val typeNameObservableField = ObservableField("")

    init {
        plateObservableField.set(vehicleModel.plateNumber)
        typeNameObservableField.set(vehicleModel.type.typeName)
    }

    fun onItemLongClick(): Boolean {
        clickEvent.value = Event(vehicleModel)
        return true
    }
}