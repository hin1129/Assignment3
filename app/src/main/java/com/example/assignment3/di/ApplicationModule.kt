package com.example.assignment3.di

import android.content.Context
import dagger.Module
import dagger.Provides

//inject context into component
@Module
class ApplicationModule (private val ApplicationContext: Context){

    @Provides
    fun providesApplicationContext() = ApplicationContext
}