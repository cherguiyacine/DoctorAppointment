package com.example.doctorappointment.ui.view.activity.patient

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Reservation
import com.example.doctorappointment.Data.model.resquest.ReservationBody
import com.example.doctorappointment.Data.repositories.LoginRepo
import com.example.doctorappointment.Data.repositories.PatientRepo
import com.example.doctorappointment.Data.room.RoomService.context
import com.example.doctorappointment.R
import com.example.doctorappointment.utils.currentPatient
import com.example.doctorappointment.utils.listReservation
import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment
import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment.OnButtonClickListener
import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment.SimpleDateMonthAndDayFormatException
import kotlinx.android.synthetic.main.activity_details_doctor.*
import java.text.SimpleDateFormat
import java.util.*


class DetailsDoctorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_doctor)
        var simpleDateFormat= SimpleDateFormat("yyyy")
        var year =simpleDateFormat.format(Date())
        simpleDateFormat= SimpleDateFormat("MM")
        var month  =simpleDateFormat.format(Date())
        simpleDateFormat= SimpleDateFormat("dd")
        var day  =simpleDateFormat.format(Date())
        val person = intent.getSerializableExtra("doctor") as Doctor
        nomDocteur.text= "DR. "+person.prenom+" "+person.nom
        photoDoctorReservation.setImageResource(R.drawable.doctor)

        conseilDemande.setOnClickListener {
            val dialog = BookingAlertFragment(person.doctorID)
            dialog.show(supportFragmentManager, "customDialog1")
        }
        numberPhoneDoctorDetails.setOnClickListener {
            val uri = Uri.parse("tel:${person.numTlp}")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            this.startActivity(intent)
        }

        directionDetails.setOnClickListener {
            val latitude = person.latitude
            val longitude = person.longitude
            val geoLocation = Uri.parse("geo:$latitude,$longitude")
            val intent = Intent(Intent.ACTION_VIEW, geoLocation)
            this.startActivity(intent)
        }
        booking.setOnClickListener {
          /*  val dialog = BookingAlertFragment()
            dialog.show(supportFragmentManager, "customDialog1")*/
            // Initialize
            val dateTimeDialogFragment = SwitchDateTimeDialogFragment.newInstance(
                "Choisir une date",
                "Confirmer",
                "Retour"
            )
             // Assign values
            dateTimeDialogFragment.startAtCalendarView()
            dateTimeDialogFragment.set24HoursMode(true)
            println(year.toInt())
            println(month.toInt())
            println(day.toInt())

            dateTimeDialogFragment.minimumDateTime =
                GregorianCalendar(year.toInt(), month.toInt(), day.toInt()).getTime()
            dateTimeDialogFragment.maximumDateTime =
                GregorianCalendar(year.toInt() + 1, month.toInt(), day.toInt()).getTime()
            dateTimeDialogFragment.setDefaultDateTime(
                GregorianCalendar(
                    year.toInt(),
                    month.toInt(),
                    day.toInt(),
                    8,
                    5
                ).getTime()
            )

// Define new day and month format
            try {
                dateTimeDialogFragment.simpleDateMonthAndDayFormat =
                    SimpleDateFormat("dd MMMM", Locale.getDefault())
            } catch (e: SimpleDateMonthAndDayFormatException) {
            }

// Set listener
            dateTimeDialogFragment.setOnButtonClickListener(object : OnButtonClickListener {
                override fun onPositiveButtonClick(date: Date?) {
                    if (date !=null){
                        val pref = context.getSharedPreferences(
                            "bdd", Context.MODE_PRIVATE
                        )
                        val patientId = pref.getInt(
                            "patientId", 0
                        )
                        var res = ReservationBody( patientId,person.doctorID,date)
                        var detailsDoctorActivity = PatientRepo.Companion
                        detailsDoctorActivity.sendReservation(context,res)
                      //  listReservation.add(res)

                    }else{
                        Toast.makeText(applicationContext, "Un problem avec la date est produit", Toast.LENGTH_LONG)
                                .show()
                    }
                    // Date is get on positive button click
                    // Do something
                    /* val qrCode= QRCodeWriter()
                    val bitmtx =qrCode.encode(
                        "Yacine",
                        BarcodeFormat.CODABAR,
                        350,
                        350
                    )
                    try {
                        // getting our qrcode in the form of bitmap.

                        // the bitmap is set inside our image
                        // view using .setimagebitmap method.
                        qrCodeImage.setImageBitmap(bitmtx.);
                        val dialog = BookingAlertFragment()
                        dialog.show(supportFragmentManager, "customDialog1")
                    } catch (WriterException e) {
                        // this method is called for
                        // exception handling.
                        Log.e("Tag", "problem with qr Code");
                    }
                }*/
                  /*  var qrgEncoder =
                        QRGEncoder("hey", null, QRGContents.Type.TEXT, 200)
                    try {
                        // getting our qrcode in the form of bitmap.
                      var  bitmap = qrgEncoder.encodeAsBitmap()
                        // the bitmap is set inside our image
                        // view using .setimagebitmap method.
                        val dialog = BookingAlertFragment()
                        dialog.show(supportFragmentManager, "customDialog1")
                        println(bitmap)
                       // qrCodeImage.setImageBitmap(bitmap)

                    } catch (e: WriterException) {
                        // this method is called for
                        // exception handling.
                        Log.e("Tag", e.toString())
                    }*/

                }

                override fun onNegativeButtonClick(date: Date?) {
                    // Date is get on negative button click
                }
            })

// Show
            dateTimeDialogFragment.show(supportFragmentManager, "dialog_time")
        }
    }
}