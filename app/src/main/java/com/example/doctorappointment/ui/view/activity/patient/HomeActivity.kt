package com.example.doctorappointment.ui.view.activity.patient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorappointment.Data.model.Doctor
import com.example.doctorappointment.R
import com.example.doctorappointment.utils.MyAdapter
import com.example.doctorappointment.utils.SpacingItemDecorator
import kotlinx.android.synthetic.main.fragment_list_doctors.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
         var spacingBetweenItem: SpacingItemDecorator =SpacingItemDecorator(40)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(spacingBetweenItem)
        recyclerView.adapter = MyAdapter(
            this, loadData()
        )
    }
    val data = mutableListOf<Doctor>()

    fun loadData(): List<Doctor> {
        data.add(
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
        data.add(
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
        data.add(
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
        data.add(
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
        data.add(
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
        data.add(
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
        data.add(
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






        return data
    }
}