package com.psyluckco.data.models

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val id : String,
    val username: String
)
