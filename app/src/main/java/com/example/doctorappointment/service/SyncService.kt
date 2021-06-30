package com.example.tp3exercice1_chergui_kadri.service

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.doctorappointment.Data.room.RoomService
import com.google.common.util.concurrent.ListenableFuture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/*
@SuppressLint("RestrictedApi")
class SyncService(val ctx: Context, val workParamters: WorkerParameters):
    ListenableWorker(ctx, workParamters){

    lateinit var  future: SettableFuture<Result>



    override fun startWork(): ListenableFuture<Result> {
        future = SettableFuture.create()
        val conseils = RoomService.appDatabase.getConseilDao().getUnSynchronizedConseils()
        addConseils(conseils)
        return future
    }





    fun addConseils(conseils:List<Conseil>) {
        val result = DoctorRepo.api.sendConseils(conseils) // consommation de l'api
        result.enqueue(object: Callback<String> {

            override fun onFailure(call: Call<String>?, t: Throwable?) {

                future.set(Result.retry())


            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {

                if(response?.isSuccessful!!) {
                    for (item in conseils) {
                        item.isSynchronized = 1
                    }
                    RoomService.appDatabase.getConseilDao().updateConseil(conseils)
                    future.set(Result.success())

                }
                else
                {
                    future.set(Result.retry())
                }
            }

        })
    }


}*/