package com.example.doctorappointment.Data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.doctorappointment.Data.Dao.ConseilDao
import com.example.doctorappointment.Data.Dao.DoctorDao
import com.example.doctorappointment.Data.Dao.TraitementDao
import com.example.doctorappointment.Data.model.Conseil
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Treatment
import com.example.doctorappointment.utils.Converter


@Database(entities = arrayOf(Doctor::class,Treatment::class, Conseil::class), version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DoctorsDao() : DoctorDao
    abstract fun TraitementDao() : TraitementDao
    abstract fun getConseilDao(): ConseilDao


}