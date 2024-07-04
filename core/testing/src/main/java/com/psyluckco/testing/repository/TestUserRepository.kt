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

val guest = User(username = "Unknown")
class TestUserRepository : UserRepository {

    private val _user = MutableSharedFlow<User>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val user: Flow<User>
        get() = _user.filterNotNull()

    override suspend fun login(username: String, password: String) : Boolean {
        delay(1000)
        _user.emit(User(username = username))
        return true
    }

    override suspend fun signup(username: String, email: String, password: String) : Boolean {
        delay(1000)
        _user.emit(User(username = username))
        return true
    }

    override suspend fun logout() {
        delay(1000)
        _user.emit(guest)
    }
}