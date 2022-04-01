package com.example.assignment3.presenter

import com.example.assignment3.model.Result
import com.example.assignment3.rest.MusicRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

// inject parameters to constructor when presenter instantiated
class MusicArtistPresenterImpl @Inject constructor(
    private val musicRepository: MusicRepository,
    private val disposables: CompositeDisposable
) : MusicArtistPresenter{

    private var musicViewContract: MusicViewContract? = null

    override fun initializePresenter(viewContract: MusicViewContract) {
        musicViewContract = viewContract
    }

    override fun checkNetworkConnection() {
        // no-op
    }

    override fun getArtist() {
        musicViewContract?.loading(true)

        musicRepository.getArtist()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { artist -> musicViewContract?.success(artist.results) },
                { error -> musicViewContract?.error(error) }
            )
            .apply {
                disposables.add(this)
            }
    }

    override fun destroyPresenter() {
        musicViewContract = null
        disposables.clear()
    }
}


//presenter lifecycle
interface MusicArtistPresenter {
    fun initializePresenter(viewContract: MusicViewContract)
    fun checkNetworkConnection()
    fun getArtist()
    fun destroyPresenter()
}

//app state
interface MusicViewContract {
    fun loading(isLoading: Boolean)
    fun success(artist: List<Result>)
    fun error(error: Throwable)
}