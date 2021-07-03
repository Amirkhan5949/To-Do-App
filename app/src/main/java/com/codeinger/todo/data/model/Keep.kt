package com.codeinger.todo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*
import javax.annotation.PropertyKey

@Entity(tableName = "keep_table")
data class Keep(

    @PrimaryKey(autoGenerate = false)
    var Kid : Int,
    var title : String,
    var description : String,
    var date : Date,
    var time : Time,
    var Cid : Int
)
