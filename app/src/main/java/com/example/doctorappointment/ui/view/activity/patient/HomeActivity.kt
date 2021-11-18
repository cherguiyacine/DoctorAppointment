package com.example.doctorappointment.ui.view.activity.patient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.doctorappointment.Data.repositories.DoctorRepo
import com.example.doctorappointment.R
import com.example.doctorappointment.ui.view.activity.login.LoginActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_list_doctors.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var options = arrayOf("","liste Rendez-vous","","liste Traitement","")
        sp_option.adapter =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        sp_option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position==1){
                    goToAppoitments()

                }else{
                    if(position==3)
                    goToTraitement()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        var homePatientActivity = DoctorRepo.Companion
        homePatientActivity.getAllDoctors(this,recyclerView,emtyDoctorMessge,progressBarDoctors)
        val pref = getSharedPreferences(
            "bdd", Context.MODE_PRIVATE
        )
        recyclerView.setVisibility(View.GONE);
        emtyDoctorMessge.setVisibility(View.GONE);
       /*  var spacingBetweenItem: SpacingItemDecorator =SpacingItemDecorator(40)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(spacingBetweenItem)
        recyclerView.adapter = MyAdapter(
            this, listDoctors
        )*/
        logoutPatient.setOnClickListener{
            pref.edit {
                putBoolean(
                    "connected", false
                )
            }
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

     /*   listapp.setOnClickListener{
            val intent = Intent(this, AppoitmentsActivity ::class.java)
            this.startActivity(intent)
        }*/

    }

    fun goToTraitement(){
        val intent = Intent(this, TraitementActivity ::class.java)
        this.startActivity(intent)
    }
    fun goToAppoitments(){
        val intent = Intent(this, AppoitmentsActivity ::class.java)
        this.startActivity(intent)
    }
  /*  fun loadData() {
        listDoctors.add(
            Doctor(
                0,
                "Kadri",
                "Said",
                "Cardio",
                " R.drawable.doctor",
                "0798989898",
                36.7762F,
                3.05997F
            )
        )
        listDoctors.add(
            Doctor(
                0,
                "Chergui",
                "Yacine",
                "Cardio",
                " R.drawable.doctor",
                "0798989898",
                36.7762F,
                3.05997F
            )
        )
        listDoctors.add(
            Doctor(
                0,
                "Bouikken",
                "Omar",
                "Cardio",
                "R.drawable.doctor",
                "0798989898",
                36.7762F,
                3.05997F
            )
        )
        listDoctors.add(
            Doctor(
                0,
                "Kadri",
                "Said",
                "Cardio",
                " R.drawable.doctor",
                "0798989898",
                36.7762F,
                3.05997F
            )
        )
        listDoctors.add(
            Doctor(
                0,
                "Kadri",
                "Said",
                "Cardio",
                "R.drawable.doctor",
                "0798989898",
                36.7762F,
                3.05997F
            )
        )
        listDoctors.add(
            Doctor(
                0,
                "lilo",
                "Said benali jadou habib",
                "Cardio",
                " R.drawable.doctor",
                "0798777777",
                36.7762F,
                3.05997F
            )
        )
        listDoctors.add(
            Doctor(
                0,
                "Kadri",
                "Said",
                "Cardio",
                " R.drawable.doctor",
                "0798989898",
                36.7762F,
                3.05997F
            )
        )
    }*/
}