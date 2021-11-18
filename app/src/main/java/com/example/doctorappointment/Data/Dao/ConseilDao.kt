package com.example.doctorappointment.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.doctorappointment.Data.model.Conseil

@Dao
interface ConseilDao {
    @Insert
    fun addConseil(conseil: Conseil)

    @Update
    fun updateConseil(conseils:List<Conseil>)

    @Query("select * from conseils")
    fun getAllConseil():List<Conseil>

    @Query ("select * from conseils where isSynchronized=0")
    fun getUnSynchronizedConseils() : List<Conseil>
}