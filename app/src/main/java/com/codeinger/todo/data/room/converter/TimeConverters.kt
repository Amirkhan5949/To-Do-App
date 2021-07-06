package com.codeinger.todo.data.room.converter

import androidx.room.TypeConverter
import java.sql.Time
import java.util.*

class TimeConverters {
    @TypeConverter
    fun toTime(timeLong: Long?): Time? {
        return timeLong?.let { Time(it) }
    }

    @TypeConverter
    fun fromTime(time: Time?): Long? {
        return time?.let { time.getTime() }?: run { null }

    }
}