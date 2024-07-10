/**
 * Created by developer on 10-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.testing.repository

import com.psyluckco.data.repository.LineupsRepository
import kotlinx.coroutines.flow.Flow

class TestLineupsRepository : LineupsRepository {
    override suspend fun get(lineupId: String): String {
        TODO("Not yet implemented")
    }

    override fun getAll(userId: String): Flow<List<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(lineupId: String) {
        TODO("Not yet implemented")
    }

    override fun create() {
        TODO("Not yet implemented")
    }

}