package com.psyluckco.data.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val user : Flow<String>
    suspend fun login(username: String, password: String)
    suspend fun signup(username: String, email: String, password: String)
    suspend fun logout()
}