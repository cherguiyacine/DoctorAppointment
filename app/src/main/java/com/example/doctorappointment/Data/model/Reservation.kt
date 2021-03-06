package com.example.doctorappointment.Data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "Reservation")
data class Reservation(
        @PrimaryKey
        var patient :Patient,
        var doctor: Doctor,
        var date: Date
) : Serializable


