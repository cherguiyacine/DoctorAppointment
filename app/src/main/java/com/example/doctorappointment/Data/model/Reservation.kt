package com.example.doctorappointment.Data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "Reservation")
data class Reservation(
        @PrimaryKey
        var ReservationID: Int,
        var patient :Doctor,
        var doctor: Doctor,
        var date: Date
) : Serializable


