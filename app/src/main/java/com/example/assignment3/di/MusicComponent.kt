package com.example.assignment3.di

import com.example.assignment3.MainActivity
import com.example.assignment3.view.ClassicFragment
import com.example.assignment3.view.PopFragment
import com.example.assignment3.view.RockFragment
import dagger.Component


//handle where items will be injected
@Component(
    //add modules from di
    modules = [
        NetworkModule::class, ApplicationModule::class,
    ]
)
//inject all objects from class
interface MusicComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: RockFragment)
    fun inject(fragment: ClassicFragment)
    fun inject(fragment: PopFragment)

}