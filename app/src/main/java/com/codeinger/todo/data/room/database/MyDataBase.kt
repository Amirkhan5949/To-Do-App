package com.codeinger.todo.data.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.data.model.Keep
import com.codeinger.todo.data.room.dao.CaregoryDao
import com.codeinger.todo.data.room.dao.KeepDao

@Database(entities =
[Category::class,Keep::class],
    version = 1,
    exportSchema = false)

abstract class MyDataBase : RoomDatabase() {

    abstract fun categoryDao() : CaregoryDao
    abstract fun keepDao() : KeepDao


    companion object {

        private var INSTANCE: MyDataBase? = null

        fun getDatabase(context: Context): MyDataBase{
            val instance = Room.databaseBuilder(
                context.applicationContext,
                MyDataBase::class.java,
                "category_database"
            ).build()
            return instance
        }
    }


}