package com.example.doctorappointment.ui.view.activity.patient

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.work.*
import com.example.doctorappointment.Data.model.Conseil
import com.example.doctorappointment.Data.repositories.PatientRepo
import com.example.doctorappointment.Data.room.RoomService
import com.example.doctorappointment.R
import com.example.tp3exercice1_chergui_kadri.service.SyncService
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
               // bookingAlertFragment.sendConseil(requireContext(),doctorID,patientId,conseilDescription.text.toString())
                RoomService.context = requireContext()
                RoomService.appDatabase.getConseilDao().addConseil(Conseil(conseilDescription.text.toString(),patientId,doctorID))
                scheduleSync()


            }
            dismiss()
        }
        // Inflate the layout for this fragment
        return rootView

    }

    private fun scheduleSync() {
        val constraints = Constraints.Builder().
        setRequiredNetworkType(NetworkType.CONNECTED).
            //    setRequiresBatteryNotLow(true).
        build()
        val req= OneTimeWorkRequest.Builder (SyncService::class.java).
        setConstraints(constraints).addTag("id1").
        build()
        val workManager = WorkManager.getInstance(requireContext())
        workManager.enqueueUniqueWork("work", ExistingWorkPolicy.REPLACE,req)

    }
}