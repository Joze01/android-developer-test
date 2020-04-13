package com.hugoapp.adt.di

import com.hugoapp.adt.presentation.parking.MainViewModel
import com.hugoapp.adt.presentation.parking.home.HomeViewModel
import com.hugoapp.adt.presentation.parking.log.LogViewModel
import com.hugoapp.adt.presentation.parking.vehicles.list.VehicleListViewModel
import com.hugoapp.adt.presentation.parking.vehicles.VehicleViewModel
import com.hugoapp.core.interactor.repository.VehicleRepository
import com.hugoapp.core.interactor.usecase.CreateVehicleUseCase
import com.hugoapp.core.interactor.usecase.GetVehiclesListUseCase
import com.hugoapp.data.db.AppDb
import com.hugoapp.data.db.util.AppDispatchers
import com.hugoapp.data.repository.VehicleRepositoryImpl
import com.hugoapp.data.util.EntityMapperHelper
import com.hugoapp.data.util.resourceManage
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    // Room:
    single { AppDb.buildDatabase(androidContext()) }
    factory { (get() as AppDb).vehicleDao() }
    factory { (get() as AppDb).VehicleTypeDao() }

    // Manager
    factory { resourceManage(androidContext()) }
    factory { EntityMapperHelper() }

    // Dispatcher
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }

    // Repositories
    single {
        VehicleRepositoryImpl(
            get(),
            get()
        ) as VehicleRepository
    }

    // Use case
    factory { GetVehiclesListUseCase(get()) }
    factory { CreateVehicleUseCase(get()) }

    // ViewModel
    factory { VehicleListViewModel(get(), get()) }
    factory { MainViewModel(resourceManage = get()) }
    factory {
        VehicleViewModel(
            dispatcher = get(),
            createVehicleUseCase = get()
        )
    }
    factory { HomeViewModel() }
    factory { LogViewModel() }


}