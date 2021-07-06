package com.codeinger.todo.data.room.converter

import androidx.room.TypeConverter
import java.util.*

class CalenderConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Calendar? {

        if(value == null) return null

        val cal = GregorianCalendar()
        cal.timeInMillis = value
        return cal
    }

    @TypeConverter
    fun toTimestamp(timestamp: Calendar?): Long? {

        if(timestamp == null) return null

        return timestamp.timeInMillis
    }
}