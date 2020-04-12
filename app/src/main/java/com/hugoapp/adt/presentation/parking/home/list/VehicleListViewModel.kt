package com.hugoapp.adt.presentation.parking.home.list

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hugoapp.adt.presentation.base.BaseViewModel
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents
import com.hugoapp.core.interactor.usecase.GetVehiclesListUseCase
import com.hugoapp.data.db.model.VehicleModel
import com.hugoapp.data.db.util.AppDispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VehicleListViewModel(
    val getVehiclesListUseCase: GetVehiclesListUseCase,
    val appDispatchers: AppDispatchers
) : BaseViewModel() {
    val itemClickEvent = MutableLiveData<Event<VehicleModel>>()

    val noDataVisible = ObservableField(false)

    var vehicleData = MutableLiveData<Event<List<VehicleModel>>>()


    fun getListData() {
        viewModelScope.launch(appDispatchers.io) {
            val result = getVehiclesListUseCase()
            withContext(appDispatchers.main) {
                result?.let {
                    vehicleData.value = Event(it)
                }
            }
        }
    }

    fun onAddNewVehicle() {
        fragmentNavigationObservable.value = Event(FragmentNavigationEvents.NEW_VEHICLE_FRAGMENT)
    }


}