package com.example.scorecheckingapp.dataClass

import android.os.Parcel
import android.os.Parcelable

data class FootballScoreDataClass(
    val time: String?,
    val firstTeamImage: Int,
    val secondTeamImage: Int,
    val firstTeamName: String?,
    val secondTeamName: String?,
    var firstTeamScore: Int?,
    var secondTeamScore: Int?

    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(time)
        parcel.writeInt(firstTeamImage)
        parcel.writeInt(secondTeamImage)
        parcel.writeString(firstTeamName)
        parcel.writeString(secondTeamName)
        parcel.writeInt(firstTeamScore!!)
        parcel.writeInt(secondTeamScore!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FootballScoreDataClass> {
        override fun createFromParcel(parcel: Parcel): FootballScoreDataClass {
            return FootballScoreDataClass(parcel)
        }

        override fun newArray(size: Int): Array<FootballScoreDataClass?> {
            return arrayOfNulls(size)
        }
    }
}
