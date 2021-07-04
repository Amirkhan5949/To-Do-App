package com.codeinger.todo.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*
import javax.annotation.PropertyKey


@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Category::class,
    parentColumns = arrayOf("Cid"),
    childColumns = arrayOf("Cid"),
    onDelete = ForeignKey.CASCADE)
))
data class Keep(

    @PrimaryKey(autoGenerate = true)
    var Kid : Int,
    var title : String,
    var description : String,
//    var date : Date,
//    var time : Time,
    var Cid : Int
)
