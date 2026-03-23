package com.hien.myapplication.repo

import com.hien.myapplication.model.Amphibian

/**
 * Repository that fetches amphibian list from amphibians api.
 */
interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}
