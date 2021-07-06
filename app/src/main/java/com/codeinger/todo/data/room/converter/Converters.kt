package com.codeinger.todo.data.room.converter

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {

        return date?.let { date.getTime() }?: run { null }

    }
}