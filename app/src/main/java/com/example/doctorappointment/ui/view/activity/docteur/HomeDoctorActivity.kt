package com.example.doctorappointment.ui.view.activity.docteur

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.R
import com.example.doctorappointment.ui.view.activity.login.LoginActivity
import com.example.doctorappointment.utils.currentDoctor
import kotlinx.android.synthetic.main.activity_home_doctor.*

class HomeDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_doctor)
        val pref = getSharedPreferences(
            "bdd", Context.MODE_PRIVATE
        )
        logOutDoctor.setOnClickListener {
            pref.edit {
                putBoolean(
                    "connected", false
                )
            }
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
          //  helloMessg.text = "Bienvenue DR. "+ currentDoctor!!.nom +" " + currentDoctor!!.prenom
    }
}