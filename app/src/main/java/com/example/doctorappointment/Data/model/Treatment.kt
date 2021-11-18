package com.example.doctorappointment.Data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "Treatment")
data class Treatment(
        var begin_date: String,
        var end_date: String,
        var description :String
)
: Serializable {
        @PrimaryKey(autoGenerate = true)
        var idTreatment:Int?=null
}

