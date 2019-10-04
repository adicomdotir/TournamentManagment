package com.example.tournomentmanagement

import android.app.Application
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

public class App: Application() {
    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/samim.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}