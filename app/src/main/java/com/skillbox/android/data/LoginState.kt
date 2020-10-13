package com.example.fragments.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginState(
    val email: String = "",
    val password: String = "",
    val isAgree: Boolean = false,
    val isAuthProgress: Boolean = false
) : Parcelable
