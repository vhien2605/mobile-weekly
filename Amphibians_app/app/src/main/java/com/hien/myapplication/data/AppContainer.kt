package com.hien.myapplication.data

import com.hien.myapplication.repo.AmphibiansRepository
import com.hien.myapplication.repo.impl.NetworkAmphibiansRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val amphibiansRepository: AmphibiansRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    override val amphibiansRepository: AmphibiansRepository by lazy {
        NetworkAmphibiansRepository(retrofit)
    }
}
