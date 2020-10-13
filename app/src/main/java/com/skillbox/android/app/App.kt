package com.example.fragments.app

import android.app.Application
import com.example.fragments.logger.MyDebugTree
import com.example.fragments.logger.ReleaseTree
import com.skillbox.android.BuildConfig
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(MyDebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
        Timber.wtf("${hashCode()}")
    }
}
