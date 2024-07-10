/**
 * Created by developer on 10-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.di

import com.psyluckco.data.repository.UserRepository
import com.psyluckco.testing.repository.TestUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindUserRepository(
        userRepository: TestUserRepository
    ) : UserRepository

}