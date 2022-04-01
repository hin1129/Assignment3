package com.example.assignment3.rest

import com.example.assignment3.model.RockArtists
import io.reactivex.Single


//layer of abstraction
interface MusicRepository{
    fun getArtist(): Single<RockArtists>
}


class MusicRepositoryImpl (
    //api code
    private val artistAPI: ArtistAPI
    ): MusicRepository {

    //network all
    override fun getArtist(): Single<RockArtists> {
        return artistAPI.getArtist()
    }
}