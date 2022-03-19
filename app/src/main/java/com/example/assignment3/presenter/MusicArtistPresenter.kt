package com.example.assignment3.presenter

import com.example.assignment3.rest.MusicRepository
import com.example.assignment3.rest.MusicRepositoryImplementation
import javax.inject.Inject

// inject parameters to constructor when presenter instantiated
class MusicArtistPresenter @Inject constructor(
    private val musicRepository: MusicRepository
){

}