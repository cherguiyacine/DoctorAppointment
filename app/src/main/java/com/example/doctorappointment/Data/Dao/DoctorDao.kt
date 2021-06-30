package com.example.doctorappointment.Data.Dao

import androidx.room.*
import com.example.doctorappointment.Data.model.Doctor

@Dao
interface DoctorDao {

    @Insert
    fun addDoctor(doctor: Doctor)

    @Insert
    fun addDoctors(doctors: List<Doctor>)

    @Delete
    fun deleteDoctor(doctor: Doctor)

    @Update
    fun updateDoctor(doctor: Doctor)

    @Query("select * from Doctor")
    fun getAllDoctor():List<Doctor>
}