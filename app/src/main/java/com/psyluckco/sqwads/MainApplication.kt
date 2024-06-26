package com.psyluckco.sqwads

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by developer on 24-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}