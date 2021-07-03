package com.example.doctorappointment.ui.view.activity.patient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorappointment.R
import com.example.doctorappointment.utils.MyAdapter
import com.example.doctorappointment.utils.MyAdapterAppointment
import com.example.doctorappointment.utils.SpacingItemDecorator
import com.example.doctorappointment.utils.listReservation
import kotlinx.android.synthetic.main.fragment_list_reservation.*

class AppoitmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appoitments)
        var spacingBetweenItem: SpacingItemDecorator =SpacingItemDecorator(40)
        recyclerViewAppointment.layoutManager = LinearLayoutManager(this)
        recyclerViewAppointment.addItemDecoration(spacingBetweenItem)
        recyclerViewAppointment.adapter = MyAdapterAppointment(
            this, listReservation
        )
        if (listReservation.isEmpty()) {
            recyclerViewAppointment.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }
        else {
            recyclerViewAppointment.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }

    }
}