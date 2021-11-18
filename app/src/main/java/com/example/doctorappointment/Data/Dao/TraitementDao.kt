package com.example.doctorappointment.Data.Dao

import androidx.room.*
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Treatment
import com.example.doctorappointment.Data.model.resquest.TraitementPatientRequest

@Dao
interface TraitementDao {


    @Insert
    fun addTraitements(traitements: List<Treatment>)

    @Query("select * from Treatment")
    fun getAllTraitement():List<Treatment>

    @Query("DELETE FROM Treatment")
    fun deleteAllTraitements()
}