package com.codeinger.todo.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*


@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Category::class,
    parentColumns = arrayOf("Cid"),
    childColumns = arrayOf("Cid"),
    onDelete = ForeignKey.CASCADE)
))
@Parcelize
data class Keep(

    @PrimaryKey(autoGenerate = true)
    var Kid: Int,
    var title: String,
    var description: String,
    var event : String,
    var date: Calendar,
     var Cid: Int
):Parcelable
