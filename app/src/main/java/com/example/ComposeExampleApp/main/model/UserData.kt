package com.example.ComposeExampleApp.main.model


import android.os.Parcelable
import androidx.annotation.Keep

@Keep
data class UserData(
    var data: Data,
    var support: Support
)