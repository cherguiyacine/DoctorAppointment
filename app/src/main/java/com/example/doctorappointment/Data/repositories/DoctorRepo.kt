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
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.room.RoomService
import com.example.doctorappointment.utils.MyAdapter
import com.example.doctorappointment.utils.SpacingItemDecorator
import com.example.doctorappointment.utils.listDoctors
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
            screen: RecyclerView,
            emtyDoctorMessge: TextView,
            progressBarDoctors: ProgressBar
        ){

            val getDoctorsRequest = api.getAllDoctors() // consommation de l'api

            getDoctorsRequest.enqueue(object : Callback<List<Doctor>> {
                override fun onResponse(
                    call: Call<List<Doctor>>,
                    response: Response<List<Doctor>>
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
                            listDoctors.clear()
                            for (m in resp!!) {
                                listDoctors.add(m)
                            }
                            var spacingBetweenItem: SpacingItemDecorator = SpacingItemDecorator(40)
                            screen.layoutManager = LinearLayoutManager(context)
                            screen.addItemDecoration(spacingBetweenItem)
                            screen.adapter = MyAdapter(
                                context, listDoctors
                            )
                            if(listDoctors.size ==0){
                                emtyDoctorMessge.setVisibility(View.VISIBLE);
                            }else{
                                screen.setVisibility(View.VISIBLE);
                            }
                            progressBarDoctors.visibility=View.GONE
                            RoomService.context=context
                            RoomService.appDatabase.DoctorsDao().deleteAllDoctor()
                            RoomService.appDatabase.DoctorsDao().addDoctors(listDoctors)
                            /* screen.layoutManager = LinearLayoutManager(context)
                             screen.adapter = MyAdapter(
                                 context, listDoctors
                             )*/
                        /*    Toast.makeText(
                                context,
                                "Succes",
                                Toast.LENGTH_SHORT
                            ).show()*/
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
                        "Vérifier votre conexion",
                        Toast.LENGTH_SHORT
                    ).show()
                    RoomService.context=context
                    var listOfDoctors=  RoomService.appDatabase.DoctorsDao().getAllDoctor()
                    listDoctors.clear()
                    for (m in listOfDoctors!!) {
                        listDoctors.add(m)
                    }
                    var spacingBetweenItem: SpacingItemDecorator = SpacingItemDecorator(40)
                    screen.layoutManager = LinearLayoutManager(context)
                    screen.addItemDecoration(spacingBetweenItem)
                    screen.adapter = MyAdapter(
                        context, listDoctors
                    )
                    if(listDoctors.size ==0){
                        emtyDoctorMessge.setVisibility(View.VISIBLE);
                    }else{
                        screen.setVisibility(View.VISIBLE);
                    }
                    progressBarDoctors.visibility=View.GONE
                }
            })
        }
    }
}