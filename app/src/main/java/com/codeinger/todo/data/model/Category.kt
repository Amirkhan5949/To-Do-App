package com.codeinger.todo.data.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(

    @PrimaryKey(autoGenerate = false)
    var Cid : Int,
    var name : String,
    var description : String
//     var img : Bitmap

)
