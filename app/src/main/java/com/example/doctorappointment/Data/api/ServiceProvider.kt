package com.example.doctorappointment.Data.api

import com.example.doctorappointment.Data.model.Doctor
import retrofit2.Call
import retrofit2.http.GET

interface ServiceProvider {

    @GET("api/doctors/all")
    fun getAllDoctors(): Call<List<Doctor>>

}