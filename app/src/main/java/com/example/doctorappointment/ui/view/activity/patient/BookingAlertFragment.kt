package com.example.doctorappointment.ui.view.activity.patient

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.doctorappointment.R
import kotlinx.android.synthetic.main.fragment_booking_alert.*
import kotlinx.android.synthetic.main.fragment_booking_alert.view.*


class BookingAlertFragment() : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_booking_alert, container, false)
        rootView.confirmConseil.setOnClickListener {
            Toast.makeText(context, "votre message est bien envoyé", Toast.LENGTH_LONG).show()
            dismiss()
        }
        // Inflate the layout for this fragment
        return rootView

    }
}