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
    fun loadData() {
        listTraitement.add(
            TraitementPatientRequest(
               Doctor( 0,
                   "Kadri",
                   "Said",
                   "Cardio",
                   " R.drawable.doctor",
                   "0798989898",
                   36.7762F,
                   3.05997F),
                Treatment(0,"12/14/2019","12/14/2019","Un texte est une série orale ou écrite de mots perçus comme constituant un ensemble cohérent, porteur de sens et utilisant les structures propres à une langue. Un texte n'a pas de longueur déterminée sauf dans le cas de poèmes à forme fixe comme le sonnet ou le haïku")
            )
        )
        listTraitement.add(
            TraitementPatientRequest(
                Doctor( 0,
                    "Yacine",
                    "Chergui",
                    "Cardio",
                    " R.drawable.doctor",
                    "0798989898",
                    36.7762F,
                    3.05997F),
                Treatment(0,"12/14/2019","12/14/2019","Un texte est une série orale ou écrite de mots perçus comme constituant un ensemble cohérent, porteur de sens et utilisant les structures propres à une langue. Un texte n'a pas de longueur déterminée sauf dans le cas de poèmes à forme fixe comme le sonnet ou le haïku")
            )
        )


    }
}