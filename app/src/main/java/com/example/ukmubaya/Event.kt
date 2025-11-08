package com.example.ukmubaya

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    var id: Int,
    var name: String,
    var description: String,
    var pictureID: Int,
    var eventDate: String,
    var crewNeed: Int,
    var total: Int) : Parcelable {

    override fun toString() = name

}
