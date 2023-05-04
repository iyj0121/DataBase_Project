package com.example.planner.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Scheduler (
    var id: Int = 0,
    var content: String? = null,
    var due_date: Date? = null,
    var roll: String? = null,
    var title: String? = null,
    var user_id: Int = 0,
    var project_id: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        TODO("due_date"),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(content)
        parcel.writeString(roll)
        parcel.writeString(title)
        parcel.writeInt(user_id)
        parcel.writeInt(project_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Scheduler> {
        override fun createFromParcel(parcel: Parcel): Scheduler {
            return Scheduler(parcel)
        }

        override fun newArray(size: Int): Array<Scheduler?> {
            return arrayOfNulls(size)
        }
    }
}