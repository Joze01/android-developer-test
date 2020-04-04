package com.hugoapp.adt

import android.app.Application
import com.sacredvalley.di.appModule
import com.sacredvalley.util.preference.base.Preference
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class ADTApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Preference.with(applicationContext)
        // TODO: Working in progress adding share preference with KOIN DI

        startKoin {
            androidContext(this@ADTApplication)
            androidLogger()
            modules(modules())
        }
    }

    /**
     * Koin Modules getter function.
     * Used in the onCreate method by the Koin framework.
     * Open to be overridden by the Test Application class.
     *
     * @return listOf Koin Modules
     */
    open fun modules() = listOf(appModule)
}