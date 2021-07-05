package com.example.doctorappointment.Data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Patient")
data class Patient(
    @PrimaryKey
    var idPatient: Int,
    var nomPatient: String,
    var prenomPatient: String
) : Serializable


