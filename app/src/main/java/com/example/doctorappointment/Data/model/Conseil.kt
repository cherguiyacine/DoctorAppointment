package com.example.doctorappointment.Data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "conseils")
data class Conseil(
    val conseilDescription: String,
    val idPatient: Int,
    val idDoctor: Int,
    var isSynchronized:Int=0
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var idConseil:Int?=null
}
