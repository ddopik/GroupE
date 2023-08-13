package com.example.ComposeExampleApp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CustomModel(
val userId: String?, val userName: String?
)  : Parcelable
