package com.hugoapp.adt.presentation.parking.vehicles.list

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hugoapp.adt.presentation.base.BaseViewModel
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents
import com.hugoapp.core.interactor.usecase.GetVehiclesListUseCase
import com.hugoapp.core.util.Resource
import com.hugoapp.data.db.model.VehicleModel
import com.hugoapp.data.db.util.AppDispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VehicleListViewModel(
    val getVehiclesListUseCase: GetVehiclesListUseCase,
    val appDispatchers: AppDispatchers
) : BaseViewModel() {
    val itemClickEvent = MutableLiveData<Event<VehicleModel>>()

    val noDataVisible = ObservableField(true)
    val progressBarVisible = ObservableField(false)

    var vehicleData = MediatorLiveData<ArrayList<VehicleModel>>()
    var vehicleDataSource: LiveData<Resource<ArrayList<VehicleModel>>> = MutableLiveData()


    fun getListData() = viewModelScope.launch(appDispatchers.main) {
        vehicleData.removeSource(vehicleDataSource)
        withContext(appDispatchers.io) {
            vehicleDataSource = getVehiclesListUseCase.invoke()
        }
        vehicleData.addSource(vehicleDataSource) {
            vehicleData.value = it.data
            progressBarVisible.set(it.status == Resource.Status.LOADING)
            noDataVisible.set(it.data.isNullOrEmpty() && it.status != Resource.Status.SUCCESS)
        }

    }


    /*


        viewModelScope.launch(appDispatchers.io)
        {
            val result = getVehiclesListUseCase()
            withContext(appDispatchers.main) {
                result?.let {
                    vehicleData.value = Event(it)
                }
            }
        }
    }
    */
    fun onAddNewVehicle() {
        fragmentNavigationObservable.value = Event(FragmentNavigationEvents.NEW_VEHICLE_FRAGMENT)
    }


}