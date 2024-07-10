/**
 * Created by developer on 04-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.testing.repository

import com.psyluckco.data.models.User
import com.psyluckco.data.repository.UserRepository
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.last
import javax.inject.Inject

val guest = User(id = "",username = "unknown")
val testUser = User(id="123", username = "TestUser")

class TestUserRepository @Inject constructor() : UserRepository {

    private val _user = MutableSharedFlow<User>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val user: Flow<User>
        get() = _user.filterNotNull()

    override val currentUser get() = _user.replayCache.firstOrNull() ?: guest

    override suspend fun login(username: String, password: String) {
        delay(1000)
        _user.emit(testUser)
    }

    override suspend fun signup(username: String, email: String, password: String) {
        delay(1000)
        _user.emit(testUser)
    }

    override suspend fun logout() {
        delay(1000)
        _user.emit(guest)
    }
}