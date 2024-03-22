package com.fajarbaihaqi.cryptopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Crypto(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
