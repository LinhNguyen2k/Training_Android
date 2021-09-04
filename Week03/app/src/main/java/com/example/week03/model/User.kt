package com.example.week03.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val email : String,
    val passWord : String
) : Parcelable