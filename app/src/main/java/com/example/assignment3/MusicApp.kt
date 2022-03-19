package com.example.assignment3

import android.app.Application
import com.example.assignment3.di.ApplicationModule
import com.example.assignment3.di.DaggerMusicComponent
import com.example.assignment3.di.MusicComponent


//this custom class is called on app layer before mainactivity layer (manifest)
//setup dagger
class MusicApp: Application() {

    override fun onCreate() {
        super.onCreate()

        musicComponent = DaggerMusicComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    //
    companion object{
        lateinit var musicComponent: MusicComponent
    }
}