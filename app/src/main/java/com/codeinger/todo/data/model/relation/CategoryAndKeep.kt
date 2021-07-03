package com.codeinger.todo.data.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.data.model.Keep

data class CategoryAndKeep(
    @Embedded val category: Category,

    @Relation(
    parentColumn = "Cid",
    entityColumn =  "Cid"
    )
    val keep: Keep
)
