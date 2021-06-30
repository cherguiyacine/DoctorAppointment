package com.example.doctorappointment.Data.repositories

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorappointment.Data.api.ServiceBuilder
import com.example.doctorappointment.Data.api.ServiceProvider
import com.example.doctorappointment.Data.model.Doctor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorRepo {
    companion object {

        val api: ServiceProvider by lazy {
            ServiceBuilder.buildService(ServiceProvider::class.java)
        }

        fun getAllDoctors(
            context: Context,
            screen:RecyclerView

        ): List<Doctor> {

            val getDoctorsRequest = api.getAllDoctors() // consommation de l'api
            var borneList = ArrayList<Doctor>()

            getDoctorsRequest.enqueue(object : Callback<List<Doctor>> {
                override fun onResponse(
                    call: Call<List<Doctor>>,
                    response: Response<List<Doctor>>
                ) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(
                            context,
                            "Un erreur cest produit 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val resp = response.body()
                        if (resp != null) {
                            for (m in resp!!) {
                                borneList.add(m)
                            }
                            screen.layoutManager = LinearLayoutManager(context)
                           /* screen.adapter = MyAdapter(
                                context, borneList
                            )*/
                            Toast.makeText(
                                context,
                                "Succes",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else {
                            Toast.makeText(
                                context,
                                "no doctors",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }

                override fun onFailure(call: Call<List<Doctor>>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "Un erreur cest produit",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            return borneList
        }
    }
}