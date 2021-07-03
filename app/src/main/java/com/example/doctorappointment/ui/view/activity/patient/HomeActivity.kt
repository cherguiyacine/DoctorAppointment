package com.example.doctorappointment.ui.view.activity.patient

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.Data.model.Reservation
import com.example.doctorappointment.R
import com.example.doctorappointment.utils.MyAdapter
import com.example.doctorappointment.utils.SpacingItemDecorator
import com.example.doctorappointment.utils.listDoctors
import com.example.doctorappointment.utils.listReservation
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_list_doctors.*
import kotlinx.android.synthetic.main.fragment_list_reservation.*
import java.util.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadData()
         var spacingBetweenItem: SpacingItemDecorator =SpacingItemDecorator(40)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(spacingBetweenItem)
        recyclerView.adapter = MyAdapter(
            this, listDoctors
        )
        if (listDoctors.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emtyDoctorMessg.setVisibility(View.VISIBLE);
        }
        else {
            recyclerView.setVisibility(View.VISIBLE);
            emtyDoctorMessg.setVisibility(View.GONE);
        }
        listapp.setOnClickListener{
            val intent = Intent(this, AppoitmentsActivity ::class.java)
            this.startActivity(intent)
        }
    }

    fun loadData() {
        listDoctors.add(
            Doctor(
                0,
                "Kadri",
                "Said",
                "Cardio",
                " R.drawable.doctor",
                "0798989898",
                36.7762F,
                3.05997F,
                "www.facebook.com",
                15
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
                3.05997F,
                "www.facebook.com",
                15
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
                3.05997F,
                "www.facebook.com",
                15
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
                3.05997F,
                "www.facebook.com",
                15
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
                3.05997F,
                "www.facebook.com",
                15
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
                3.05997F,
                "www.facebook.com",
                15
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
                3.05997F,
                "www.facebook.com",
                15
            )
        )
    }
}