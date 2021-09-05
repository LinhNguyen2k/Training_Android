package com.example.week03.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoHomeTwo(val text1 : String, val text2 : String, val text3: String, val text4: String) :
    Parcelable