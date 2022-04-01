package com.example.assignment3.di

import android.view.Gravity.apply
import com.example.assignment3.presenter.MusicArtistPresenterImpl
import com.example.assignment3.rest.*
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// provide objects
@Module
class NetworkModule {

    // provide objects to dagger (with gson)
    //    @Singleton
    @Provides
    fun providesRetrofitService(okHttpClient:OkHttpClient, gson:Gson): ArtistAPI{
      return Retrofit.Builder()
          .baseUrl(ArtistAPI.BASE_URL)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())   //observable
          .client(okHttpClient)
          .build()
          .create(ArtistAPI::class.java)
    }

    // for providesRetrofitService argument
    @Provides
    fun providesOkHttpClient(requestInterceptor:RequestInterceptor,
                             httpLoggingInterceptor:HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    // for providesOkHttpClient argument, need to provide class for this fun
    @Provides
    fun providesRequestInterceptor() = RequestInterceptor()

    // for providesOkHttpClient argument
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // for providesRetrofitService argument
    @Provides
    fun providesGson() = Gson()



    @Provides
    fun providesMusicRepositoryImplementation(artistAPI: ArtistAPI): MusicRepository{
        return MusicRepositoryImpl(artistAPI)
    }
}