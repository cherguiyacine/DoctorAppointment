package com.example.doctorappointment.Data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.doctorappointment.Data.model.Doctor
import retrofit2.Converter

@Database(entities = arrayOf(Doctor::class), version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
   // abstract fun getBookingDao(): BookingDao

}