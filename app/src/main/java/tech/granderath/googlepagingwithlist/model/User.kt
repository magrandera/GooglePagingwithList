package tech.granderath.googlepagingwithlist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
  val username: String,
  val name: String
) : Parcelable
