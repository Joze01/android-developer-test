package com.sacredvalley.di

import com.hugoapp.data.db.AppDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    // Room:
    single { AppDb.buildDatabase(androidContext()) }

}