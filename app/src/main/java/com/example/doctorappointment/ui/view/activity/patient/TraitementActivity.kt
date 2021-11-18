package com.example.doctorappointment.ui.view.activity.patient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Treatment
import com.example.doctorappointment.Data.model.resquest.TraitementPatientRequest
import com.example.doctorappointment.Data.repositories.PatientRepo
import com.example.doctorappointment.R
import com.example.doctorappointment.utils.MyAdapterTraitement
import com.example.doctorappointment.utils.SpacingItemDecorator
import com.example.doctorappointment.utils.listTraitement
import kotlinx.android.synthetic.main.activity_appoitments.*
import kotlinx.android.synthetic.main.activity_traitement.*
import kotlinx.android.synthetic.main.fragment_list_reservation.*
import kotlinx.android.synthetic.main.fragment_list_traitement.*

class TraitementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traitement)
        var traitementActivity = PatientRepo.Companion
        traitementActivity.getTraitement(this,recyclerViewTraitement,progressBarTraitement,emptyNoTraitement)

        recyclerViewTraitement.setVisibility(View.GONE);
        emptyNoTraitement.setVisibility(View.GONE);

    }

}