package com.example.doctorappointment.utils

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Patient
import com.example.doctorappointment.Data.model.Reservation
import com.example.doctorappointment.Data.model.resquest.ReservationPatientRequest
import com.example.doctorappointment.Data.model.resquest.TraitementPatientRequest
import com.example.doctorappointment.R
import java.util.*

const val BASE_URL = "https://8b9c7b533c16.ngrok.io/"
val listDoctors = mutableListOf<Doctor>()
val listReservation = mutableListOf<ReservationPatientRequest>()
val listTraitement = mutableListOf<TraitementPatientRequest>()
var currentDoctor : Doctor?=null
var currentPatient : Patient?=null

class utils {
    //méthode pour show and hide passwords


}