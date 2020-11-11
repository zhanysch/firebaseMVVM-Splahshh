package com.example.backend.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsItem (
    val desc : String = "",
    val image : String = "",
    val title : String = ""
): Parcelable