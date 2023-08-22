package com.example.ComposeExampleApp.main.model


import androidx.annotation.Keep

@Keep
data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)