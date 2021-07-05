package com.example.doctorappointment.ui.view.activity.patient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.doctorappointment.Data.repositories.PatientRepo
import com.example.doctorappointment.R
import kotlinx.android.synthetic.main.activity_appoitments.*
import kotlinx.android.synthetic.main.fragment_list_reservation.*

class AppoitmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appoitments)
        var appoitmentsActivity = PatientRepo.Companion
        appoitmentsActivity.getReservations(this,recyclerViewAppointment,progressBarReservation,emptyNoReservation)


            recyclerViewAppointment.setVisibility(View.GONE);
            emptyNoReservation.setVisibility(View.GONE);



    }
}