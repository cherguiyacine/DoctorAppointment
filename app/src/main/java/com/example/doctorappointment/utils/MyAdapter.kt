package com.example.doctorappointment.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.R

/*
class MyAdapter(val context: Context, var data: List<Doctor>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.doctor_layout, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameDoctor.text = data[position].nom
        holder.prenomDoctor.text = data[position].prenom
        holder.numberPhoneDoctor.text = data[position].numTlp
        holder.specialiteDoctor.text = data[position].specialite
        Glide.with(context).load(BASE_URL+data[position].imgUrl).into(holder.photoDoctor)
       // holder.photoDoctor.setImageResource(R.drawable.doctor)
        holder.numberPhoneDoctor.setOnClickListener { view ->
            val uri = Uri.parse("tel:${data[position].numTlp}")
            val intent = Intent(Intent.ACTION_DIAL, uri)

            context.startActivity(intent)

        }
        holder.direction.setOnClickListener { view ->
            val latitude = data[position].latitude
            val longitude = data[position].longitude
            val geoLocation = Uri.parse("geo:$latitude,$longitude")
            val intent = Intent(Intent.ACTION_VIEW, geoLocation)
            context.startActivity(intent)

        }
        holder.itemView.setOnClickListener { view ->

            if (isTwoPane()) {

                val activity = context as Activity
                val img = activity.findViewById(R.id.image) as ImageView
                //img.setImageResource(data[position].imgUrl)
                Glide.with(context).load(BASE_URL+data[position].imgUrl).into(img)

                val nameDoctor = activity.findViewById(R.id.nom) as TextView
                nameDoctor.text = data[position].nom
                val prenomDoctor = activity.findViewById(R.id.prenom) as TextView
                prenomDoctor.text = data[position].prenom
                val specialite = activity.findViewById(R.id.specialite) as TextView
                specialite.text = data[position].specialite
                val tlp = activity.findViewById(R.id.numerotlp) as TextView
                tlp.text = data[position].numTlp
                val annee_exp = activity.findViewById(R.id.anneeExperience) as TextView
                annee_exp.text = data[position].exp.toString()
                val facebook = activity.findViewById(R.id.facebookPage) as TextView
                facebook.text = data[position].url

            }
            else {
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra("doctor",data[position])
                context.startActivity(intent)
            }

        }


    }
    private fun isTwoPane():Boolean{
        val activity = context as Activity
        return activity.findViewById<View>(R.id.fragment)==null
    }
    override fun getItemCount(): Int {
        return data.size
    }

}


class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameDoctor = view.findViewById<TextView>(R.id.nameDoctor) as TextView
    val prenomDoctor = view.findViewById<TextView>(R.id.prenomDoctor) as TextView
    val numberPhoneDoctor = view.findViewById<TextView>(R.id.numberPhoneDoctor) as TextView
    val specialiteDoctor = view.findViewById<TextView>(R.id.specialiteDoctor) as TextView
    val photoDoctor = view.findViewById<ImageView>(R.id.imageView) as ImageView
    val direction = view.findViewById<TextView>(R.id.direction) as TextView

}*/
