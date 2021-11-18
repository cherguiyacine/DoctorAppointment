package com.example.doctorappointment.Data.api

import com.example.doctorappointment.Data.model.Conseil
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Patient
import com.example.doctorappointment.Data.model.Reservation
import com.example.doctorappointment.Data.model.resquest.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceProvider {
    @POST("api/auth-doctor")
    fun loginDoctor(
        @Body info: LoginBody
    ): Call<Doctor>

    @POST("api/auth-patient")
    fun loginPatient(
        @Body info: LoginBody
    ): Call<Patient>

    @GET("api/getAllDoctors")
    fun getAllDoctors(
    ): Call<List<Doctor>>

    @POST("api/addConseil")
    fun sendConseil(
        @Body info: ConseilBody
    ): Call<basicRequest>

    @POST("addConseils")
    fun sendConseils(@Body conseils: List<Conseil>):Call<String>

    @POST("api/AddBooking")
    fun sendReservation(
        @Body info: ReservationBody
    ): Call<basicRequest>

    @GET("/api/getPatientBookings/{idPatient}")
    fun getReservations(
        @Path("idPatient") idPatient: Int
    ): Call<List<ReservationPatientRequest>>

    @GET("/api/getPatientTreatments/{idPatient}")
    fun getTraitement(
        @Path("idPatient") idPatient: Int
    ): Call<List<TraitementPatientRequest>>
}