package com.codeinger.todo.data.model

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    var Cid : Int,
    var name : String,
    var description : String
//     var img : Bitmap

):Parcelable
