package com.example.doctorappointment.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorappointment.Data.model.Reservation
import com.example.doctorappointment.Data.model.resquest.ReservationPatientRequest
import com.example.doctorappointment.Data.model.resquest.TraitementPatientRequest
import com.example.doctorappointment.R
import com.google.zxing.WriterException
import de.hdodenhof.circleimageview.CircleImageView


class MyAdapterTraitement(val context: Context, var data: List<TraitementPatientRequest>) :
    RecyclerView.Adapter<MyViewHolderTraitement>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTraitement {
        return MyViewHolderTraitement(
            LayoutInflater.from(context).inflate(R.layout.traitement_layout, parent, false)
        )

    }
    override fun onBindViewHolder(holder: MyViewHolderTraitement, position: Int) {
        holder.nomDocteurTraitement.text = data[position].doctor.nom +" "+ data[position].doctor.prenom
        //   holder.prenomDoctor.text = data[position].prenom
        // Glide.with(context).load(BASE_URL+data[position].imgUrl).into(holder.photoDoctor)
        holder.photoDoctorTraitement.setImageResource(R.drawable.doctor)
        holder.dateTraitement.text="Date debut :"+data[position].treatment.begin_date.substring(0,10)+"\nDate fin :"+data[position].treatment.end_date.substring(0,10)
        holder.traitementDescription.text=data[position].treatment.description
    }
   /* private fun isTwoPane():Boolean{
        val activity = context as Activity
        return activity.findViewById<View>(R.id.fragment)==null
    }*/
    override fun getItemCount(): Int {
        return data.size
    }

}


class MyViewHolderTraitement(view: View) : RecyclerView.ViewHolder(view) {
    val nomDocteurTraitement = view.findViewById<TextView>(R.id.nomDocteurTraitement) as TextView
    val dateTraitement = view.findViewById<TextView>(R.id.dateTraitement) as TextView
    val traitementDescription = view.findViewById<TextView>(R.id.traitementDescription) as TextView
    var photoDoctorTraitement: CircleImageView = view.findViewById(R.id.photoDoctorTraitement)

}
