package com.hien.myapplication.repo.impl

import com.hien.myapplication.model.Amphibian
import com.hien.myapplication.repo.AmphibiansRepository
import retrofit2.Retrofit
import retrofit2.http.GET

/**
 * Retrofit service interface for fetching amphibian data.
 * Defined here to avoid using a separate network folder.
 */
interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}

/**
 * Network Implementation of Repository that fetches amphibian list from amphibians api.
 */
class NetworkAmphibiansRepository(
    private val retrofit: Retrofit
) : AmphibiansRepository {
    
    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override suspend fun getAmphibians(): List<Amphibian> = retrofitService.getAmphibians()
}
