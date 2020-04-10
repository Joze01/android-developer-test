package com.hugoapp.adt.di

import com.hugoapp.adt.presentation.parking.MainViewModel
import com.hugoapp.adt.presentation.parking.home.HomeViewModel
import com.hugoapp.data.db.AppDb
import com.hugoapp.data.util.resourceManage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    // Room:
    single { AppDb.buildDatabase(androidContext()) }

    // Manager
    factory { resourceManage(androidContext()) }

    // ViewModel
    factory { HomeViewModel() }
    factory { MainViewModel(resourceManage = get()) }

}