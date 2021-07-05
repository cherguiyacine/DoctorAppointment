package com.example.doctorappointment.Data.model.resquest

import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Reservation

data class ReservationPatientRequest(var doctor:Doctor,var booking:ReservationBody)
