/**
 * Created by developer on 10-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.data.repository

import kotlinx.coroutines.flow.Flow

interface LineupsRepository {
    suspend fun get(lineupId : String) : String
    fun getAll(userId : String) : Flow<List<String>>
    suspend fun delete(lineupId : String)
    fun create()

}