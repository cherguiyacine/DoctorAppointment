package com.example.doctorappointment.ui.view.activity.patient

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.doctorappointment.Data.repositories.PatientRepo
import com.example.doctorappointment.R
import kotlinx.android.synthetic.main.fragment_booking_alert.*
import kotlinx.android.synthetic.main.fragment_booking_alert.view.*


class BookingAlertFragment(var doctorID: Int) : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_booking_alert, container, false)
        rootView.confirmConseil.setOnClickListener {
            if(conseilDescription.text.isEmpty()){
                Toast.makeText(context, "Votre message est vide", Toast.LENGTH_LONG).show()
            }else{
                val pref = requireContext().getSharedPreferences(
                    "bdd", Context.MODE_PRIVATE
                )
                val patientId = pref.getInt(
                    "patientId", 0
                )
                var bookingAlertFragment = PatientRepo.Companion
                bookingAlertFragment.sendConseil(requireContext(),doctorID,patientId,conseilDescription.text.toString())

            }
            dismiss()
        }
        // Inflate the layout for this fragment
        return rootView

    }
}