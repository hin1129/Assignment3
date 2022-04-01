package com.example.assignment3.di

import com.example.assignment3.presenter.MusicArtistPresenter
import com.example.assignment3.presenter.MusicArtistPresenterImpl
import com.example.assignment3.rest.MusicRepository
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class PresenterModule {

    @Provides
    fun providesCompositeDisposable() = CompositeDisposable()


    @Provides
    fun providesMusicPresenter(
        musicRepository: MusicRepository,
        disposable: CompositeDisposable
    ): MusicArtistPresenter {
        return MusicArtistPresenterImpl(musicRepository, disposable)
    }
}