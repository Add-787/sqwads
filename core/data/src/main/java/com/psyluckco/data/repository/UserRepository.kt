package com.psyluckco.data.repository

import com.psyluckco.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val user : Flow<User?>
    suspend fun login(username: String, password: String) : Boolean
    suspend fun signup(username: String, email: String, password: String) : Boolean
    suspend fun logout()
}