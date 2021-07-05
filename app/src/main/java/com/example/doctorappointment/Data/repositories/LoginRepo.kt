package com.example.doctorappointment.Data.repositories

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.doctorappointment.Data.api.ServiceBuilder
import com.example.doctorappointment.Data.api.ServiceProvider
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Patient
import com.example.doctorappointment.Data.model.resquest.LoginBody
import com.example.doctorappointment.Data.model.resquest.LoginDoctorRequest
import com.example.doctorappointment.Data.model.resquest.LoginPatientRequest
import com.example.doctorappointment.ui.view.activity.docteur.HomeDoctorActivity
import com.example.doctorappointment.ui.view.activity.patient.HomeActivity
import com.example.doctorappointment.utils.currentDoctor
import com.example.doctorappointment.utils.currentPatient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepo {
    companion object {

        val api: ServiceProvider by lazy {
            ServiceBuilder.buildService(ServiceProvider::class.java)
        }

        fun loginDoctor(
            context: Context,
            phoneNumber :String,
            password:String
        ) {

            var loginBody = LoginBody(phoneNumber, password)
           val authRequest = api.loginDoctor(loginBody) // consommation de l'api
            val pref = context.getSharedPreferences(
                "bdd", Context.MODE_PRIVATE
            )
            authRequest.enqueue(object : Callback<Doctor> {
                override fun onResponse(
                    call: Call<Doctor>,
                    response: Response<Doctor>
                ) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(
                            context,
                            "Un erreur cest produit",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Auth with succes",
                            Toast.LENGTH_SHORT
                        ).show()
                        var doc = response.body()
                        if(doc != null){
                            currentDoctor=Doctor(doc.doctorID,doc.nom,doc.prenom,doc.specialite,doc.imgUrl,doc.numTlp,doc.longitude,doc.latitude)
                            with(pref?.edit()) {
                                this?.putBoolean( "connected", true)
                                this?.putInt("typeUser", 0)
                                this?.putInt("doctorId", doc.doctorID)
                                this?.apply()
                            }
                            val myIntent = Intent(context, HomeDoctorActivity::class.java)
                            context.startActivity(myIntent)
                            (context as Activity).finish()
                        }
                    }
                }

                override fun onFailure(call: Call<Doctor>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "Vérifier votre conexion",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
        fun loginPatient(
            context: Context,
            phoneNumber :String,
            password:String
        ) {

            var loginBody = LoginBody(phoneNumber, password)
               val authRequest = api.loginPatient(loginBody) // consommation de l'api

            authRequest.enqueue(object : Callback<Patient> {
                override fun onResponse(
                    call: Call<Patient>,
                    response: Response<Patient>
                ) {
                    val pref = context.getSharedPreferences(
                        "bdd", Context.MODE_PRIVATE
                    )
                    if (!response.isSuccessful()) {
                        Toast.makeText(
                            context,
                            "Un erreur cest produit 1",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Auth with succes",
                            Toast.LENGTH_SHORT
                        ).show()
                        var doc = response.body()
                        if(doc != null){
                            currentPatient=Patient(doc.idPatient,doc.nomPatient,doc.prenomPatient)
                            with(pref?.edit()) {
                                this?.putBoolean( "connected", true)
                                this?.putInt("typeUser", 1)
                                this?.putInt("patientId", doc.idPatient)
                                this?.apply()
                            }
                            val myIntent = Intent(context, HomeActivity::class.java)
                            context.startActivity(myIntent)
                            (context as Activity).finish()
                        }
                    }
                }

                override fun onFailure(call: Call<Patient>, t: Throwable) {
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