package com.example.doctorappointment.Data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Doctor")
data class Doctor(
    @PrimaryKey
    var doctorID: Int,
    val nom: String,
    val prenom: String,
    val specialite: String,
    val imgUrl: String,
    val numTlp: String,
    val longitude: Float,
    val latitude: Float,
    val url: String,
    val exp: Int,
) : Serializable


