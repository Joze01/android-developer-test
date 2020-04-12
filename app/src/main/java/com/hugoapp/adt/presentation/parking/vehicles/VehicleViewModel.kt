package com.hugoapp.adt.presentation.parking.vehicles

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hugoapp.adt.presentation.base.BaseViewModel
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents
import com.hugoapp.core.interactor.usecase.CreateVehicleUseCase
import com.hugoapp.data.db.model.VehicleModel
import com.hugoapp.data.db.model.VehicleTypeModel
import com.hugoapp.data.db.util.AppDispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VehicleViewModel(
    val dispatcher: AppDispatchers,
    val createVehicleUseCase: CreateVehicleUseCase
) : BaseViewModel() {

    val vehiclePlateObservableField = ObservableField("")
    val vehicleTypeObservableField = ObservableField("")

    fun onSaveClick() {
        createNewVehicle()
    }

    fun createNewVehicle() {
        val VehicleTypeModel = VehicleTypeModel(
            typeId = 1,
            typeName = "Oficial",
            typeDescription = "Vehiculos oficiales",
            farePerMinute = 0.0,
            isPaymentRequired = false
        )
        vehiclePlateObservableField.get()?.let {
            val vehicleModel = VehicleModel(it, VehicleTypeModel)
            viewModelScope.launch(dispatcher.io) {
                createVehicleUseCase(vehicleModel)
                withContext(dispatcher.main) {
                    fragmentNavigationObservable.value = Event(FragmentNavigationEvents.BACK)
                }
            }
        }

    }

}