package com.example.doctorappointment.Data.repositories

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorappointment.Data.api.ServiceBuilder
import com.example.doctorappointment.Data.api.ServiceProvider
import com.example.doctorappointment.Data.model.resquest.*
import com.example.doctorappointment.utils.*
import kotlinx.android.synthetic.main.activity_appoitments.*
import kotlinx.android.synthetic.main.fragment_list_reservation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatientRepo {
    companion object {

        val api: ServiceProvider by lazy {
            ServiceBuilder.buildService(ServiceProvider::class.java)
        }

        fun sendConseil(
            context: Context,
            idDoctor: Int,
            idPatient: Int,
            descriptionConseil: String

        ) {
            var conseilBody = ConseilBody(idPatient, idDoctor, descriptionConseil)
            val sendConseilRequest = api.sendConseil(conseilBody) // consommation de l'api
            println(conseilBody)
              sendConseilRequest.enqueue(object : Callback<basicRequest> {
                  override fun onResponse(
                      call: Call<basicRequest>,
                      response: Response<basicRequest>
                  ) {

                      if (!response.isSuccessful()) {
                          Toast.makeText(
                              context,
                              "Un erreur cest produit",
                              Toast.LENGTH_SHORT
                          ).show()
                      } else {
                          val resp = response.body()
                          if (resp != null) {
                              Toast.makeText(
                                  context,
                                  "Conseil ajouter avec succée",
                                  Toast.LENGTH_SHORT
                              ).show()
                          }

                      }
                  }

                  override fun onFailure(call: Call<basicRequest>, t: Throwable) {
                      Toast.makeText(
                          context,
                          "Un erreur cest produit",
                          Toast.LENGTH_SHORT
                      ).show()
                  }
              })
        }

        fun sendReservation(
            context: Context,
            reservation: ReservationBody

        ) {
            val sendConseilRequest = api.sendReservation(reservation) // consommation de l'api

            sendConseilRequest.enqueue(object : Callback<basicRequest> {
                override fun onResponse(
                    call: Call<basicRequest>,
                    response: Response<basicRequest>
                ) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(
                            context,
                            "Un erreur cest produit",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val resp = response.body()
                        if (resp != null) {
                            Toast.makeText(
                                context,
                                resp.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun onFailure(call: Call<basicRequest>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "Vérifier votre conexion",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }

        fun getReservations(
            context: Context,
            recyclerViewAppointment: RecyclerView,
            progressBarReservation: ProgressBar,
            emptyNoReservation: TextView
        ) {
            val pref = context.getSharedPreferences(
                "bdd", Context.MODE_PRIVATE
            )
            val patientId = pref.getInt(
                "patientId", 0
            )
            val sendConseilRequest = api.getReservations(patientId) // consommation de l'api

            sendConseilRequest.enqueue(object : Callback<List<ReservationPatientRequest>> {
                override fun onResponse(
                    call: Call<List<ReservationPatientRequest>>,
                    response: Response<List<ReservationPatientRequest>>
                ) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(
                            context,
                            "Un erreur cest produit",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val resp = response.body()
                        println(resp)
                        if (resp != null) {
                            listReservation.clear()
                            for (m in resp!!) {
                                listReservation.add(m)
                            }
                            var spacingBetweenItem: SpacingItemDecorator = SpacingItemDecorator(40)
                            recyclerViewAppointment.layoutManager = LinearLayoutManager(context)
                            recyclerViewAppointment.addItemDecoration(spacingBetweenItem)
                            recyclerViewAppointment.adapter = MyAdapterAppointment(
                                context, listReservation
                            )
                            progressBarReservation.visibility=View.GONE

                            if (listReservation.size ==0) {
                                emptyNoReservation.setVisibility(View.VISIBLE);
                            }else{
                                recyclerViewAppointment.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<ReservationPatientRequest>>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "Vérifier votre conexion",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
        fun getTraitement(
            context: Context,
            recyclerViewTraitement: RecyclerView,
            progressBarTraitement: ProgressBar,
            emptyNoTraitement: TextView
        ) {
            val pref = context.getSharedPreferences(
                "bdd", Context.MODE_PRIVATE
            )
            val patientId = pref.getInt(
                "patientId", 0
            )
            val sendConseilRequest = api.getTraitement(patientId) // consommation de l'api

            sendConseilRequest.enqueue(object : Callback<List<TraitementPatientRequest>> {
                override fun onResponse(
                    call: Call<List<TraitementPatientRequest>>,
                    response: Response<List<TraitementPatientRequest>>
                ) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(
                            context,
                            "Un erreur cest produit",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val resp = response.body()
                        println(resp)
                        if (resp != null) {
                            listTraitement.clear()
                            for (m in resp!!) {
                                listTraitement.add(m)
                            }
                            var spacingBetweenItem: SpacingItemDecorator = SpacingItemDecorator(10)
                            recyclerViewTraitement.layoutManager = LinearLayoutManager(context)
                            recyclerViewTraitement.addItemDecoration(spacingBetweenItem)
                            recyclerViewTraitement.adapter = MyAdapterTraitement(
                                context, listTraitement
                            )
                            progressBarTraitement.visibility=View.GONE

                            if (listTraitement.size ==0) {
                                emptyNoTraitement.setVisibility(View.VISIBLE);
                            }else{
                                recyclerViewTraitement.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<TraitementPatientRequest>>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "Vérifier votre conexion",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }
}