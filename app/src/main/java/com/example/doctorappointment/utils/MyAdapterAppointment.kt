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
import com.example.doctorappointment.R
import com.google.zxing.WriterException
import de.hdodenhof.circleimageview.CircleImageView


class MyAdapterAppointment(val context: Context, var data: List<ReservationPatientRequest>) :
    RecyclerView.Adapter<MyViewHolderAppointment>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderAppointment {
        return MyViewHolderAppointment(
            LayoutInflater.from(context).inflate(R.layout.reservation_layout, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MyViewHolderAppointment, position: Int) {
        holder.nameDoctorReservation.text = data[position].doctor.nom +" "+ data[position].doctor.prenom
        //   holder.prenomDoctor.text = data[position].prenom
        holder.numberPhoneDoctorTextReservation.text = data[position].doctor.numTlp
        holder.specialiteDoctorReservation.text = data[position].doctor.specialite
        // Glide.with(context).load(BASE_URL+data[position].imgUrl).into(holder.photoDoctor)
        holder.photoDoctorReservation.setImageResource(R.drawable.doctor)
        holder.numberPhoneDoctorReservation.setOnClickListener {
            val uri = Uri.parse("tel:${data[position].doctor.numTlp}")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            context.startActivity(intent)
        }
        holder.directionReservation.setOnClickListener {
            val latitude = data[position].doctor.latitude
            val longitude = data[position].doctor.longitude
            val geoLocation = Uri.parse("geo:$latitude,$longitude")
            val intent = Intent(Intent.ACTION_VIEW, geoLocation)
            context.startActivity(intent)
        }
        holder.itemView.setOnClickListener { view ->
        }
        var qrgEncoder =
            QRGEncoder(
                data[position].doctor.nom + "_"+ data[position].booking.dateBooking +"_"+data[position].booking.heureBooking ,
                null,
                QRGContents.Type.TEXT,
                400
            )
        try {
            // getting our qrcode in the form of bitmap.
             var bitmap = qrgEncoder.encodeAsBitmap()
            // the bitmap is set inside our image
            // view using .setimagebitmap method.
           holder.qrCodeImageReservation.setImageBitmap(bitmap)

            // qrCodeImage.setImageBitmap(bitmap)

        } catch (e: WriterException) {
            // this method is called for
            // exception handling.
            Log.e("Tag", e.toString())
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


class MyViewHolderAppointment(view: View) : RecyclerView.ViewHolder(view) {
    val nameDoctorReservation = view.findViewById<TextView>(R.id.nameDoctorReservation) as TextView
    val numberPhoneDoctorTextReservation = view.findViewById<TextView>(R.id.numberPhoneDoctorTextReservation) as TextView
    val numberPhoneDoctorReservation = view.findViewById<TextView>(R.id.numberPhoneDoctorReservation) as View
    val specialiteDoctorReservation = view.findViewById<TextView>(R.id.specialiteDoctorReservation) as TextView
    var photoDoctorReservation: CircleImageView = view.findViewById(R.id.photoDoctorReservation)
    var qrCodeImageReservation: ImageView = view.findViewById(R.id.qrCodeImageReservation)
    val directionReservation = view.findViewById<TextView>(R.id.directionReservation) as View

}
