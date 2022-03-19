package com.example.assignment3.rest

import com.example.assignment3.model.RockArtists
import io.reactivex.Single
import retrofit2.http.GET

interface ArtistAPI {

    //get data from retrofit, use singleton observable to make task from json file
    @GET(Rock_Artists)
    fun getArtist(): Single<RockArtists>


    //https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50
    // retrieve url
    companion object{
        const val BASE_URL = "https://itunes.apple.com/"
        private const val Rock_Artists= "search?term=rock&amp;media=music&amp;entity=song&amp;limit=50"
    }

}