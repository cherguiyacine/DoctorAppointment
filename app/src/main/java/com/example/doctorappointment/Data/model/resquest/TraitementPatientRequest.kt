package com.example.doctorappointment.Data.model.resquest

import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Reservation
import com.example.doctorappointment.Data.model.Treatment

data class TraitementPatientRequest(var doctor:Doctor, var treatment: Treatment)
