package c.m.jetheroes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val id: String,
    val name: String,
    val photoUrl: String,
) : Parcelable
