package com.example.doctorappointment.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.R
import com.example.doctorappointment.ui.view.activity.patient.DetailsDoctorActivity
import de.hdodenhof.circleimageview.CircleImageView


class MyAdapter(val context: Context, var data: MutableList<Doctor>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.doctor_layout, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameDoctor.text = data[position].nom +" "+ data[position].prenom
     //   holder.prenomDoctor.text = listDoctors[position].prenom
        holder.numberPhoneDoctorText.text = listDoctors[position].numTlp
        holder.specialiteDoctor.text = data[position].specialite
       // Glide.with(context).load(BASE_URL+data[position].imgUrl).into(holder.photoDoctor)
        holder.photoDoctor.setImageResource(R.drawable.doctor)
        holder.numberPhoneDoctor.setOnClickListener {
            val uri = Uri.parse("tel:${data[position].numTlp}")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            context.startActivity(intent)
        }
        holder.direction.setOnClickListener {
            val latitude = data[position].latitude
            val longitude = data[position].longitude
            val geoLocation = Uri.parse("geo:$latitude,$longitude")
            val intent = Intent(Intent.ACTION_VIEW, geoLocation)
            context.startActivity(intent)
        }
        holder.itemView.setOnClickListener { view ->
                val intent = Intent(context, DetailsDoctorActivity ::class.java)
                intent.putExtra("doctor", data[position])
                context.startActivity(intent)
        }


    }
   /* private fun isTwoPane():Boolean{
        val activity = context as Activity
        return activity.findViewById<View>(R.id.fragment)==null
    }*/
    override fun getItemCount(): Int {
        return data.size
    }

}


class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameDoctor = view.findViewById<TextView>(R.id.nameDoctor) as TextView
    val numberPhoneDoctorText = view.findViewById<TextView>(R.id.numberPhoneDoctorText) as TextView
    val numberPhoneDoctor = view.findViewById<TextView>(R.id.numberPhoneDoctor) as View
    val specialiteDoctor = view.findViewById<TextView>(R.id.specialiteDoctor) as TextView
    var photoDoctor: CircleImageView = view.findViewById(R.id.photoDoctorTraitement)
    val direction = view.findViewById<TextView>(R.id.direction) as View

}
