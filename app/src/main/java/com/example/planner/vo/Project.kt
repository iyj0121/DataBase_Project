package com.example.planner.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Project(
    var id: Int = 0,
    var title: String? = null,
    var content: String? = null,
    var due_date: Date? = null,
    var meeting: Date? = null,
    var manager: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        TODO("due_date"),
        TODO("meeting"),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(manager)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Project> {
        override fun createFromParcel(parcel: Parcel): Project {
            return Project(parcel)
        }

        override fun newArray(size: Int): Array<Project?> {
            return arrayOfNulls(size)
        }
    }
}
