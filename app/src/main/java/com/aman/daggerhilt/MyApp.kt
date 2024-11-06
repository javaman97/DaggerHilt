package com.aman.daggerhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // This will make this class trigger Hilt’s code generation which will have the base class for our application and it acts as the application-level dependency container
class MyApp: Application() {
}