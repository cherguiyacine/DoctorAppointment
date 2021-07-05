package com.example.doctorappointment.ui.view.activity.login

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import com.example.doctorappointment.Data.repositories.LoginRepo
import com.example.doctorappointment.R
import com.example.doctorappointment.ui.view.activity.docteur.HomeDoctorActivity
import com.example.doctorappointment.ui.view.activity.patient.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    var mIsShowPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        toggleButton.setText("Choisir votre profile")
        toggleButton.setTextOff("Patient");
        toggleButton.setTextOn("Docteur");
        logIn.isEnabled=false
        var userType =2 // 0 pour doctor et 1 pour patient
        val pref = getSharedPreferences(
            "bdd", Context.MODE_PRIVATE
        )
        val con = pref.getBoolean(
            "connected", false
        )
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // The toggle is enabled
                userType=0
                logIn.isEnabled=true
            } else {
                // The toggle is disabled
                userType=1
                logIn.isEnabled=true
            }
        }
        if (con) {
            var typeUsere = pref.getInt(
                "typeUser", 2
            )
            when (typeUsere) {
                0 -> {
                    val intent = Intent(this, HomeDoctorActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                1 -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> { // Note the block
                    print("No such connection")
                }
            }

        }
        logIn.setOnClickListener {
            if (phoneNumber?.text.isNullOrEmpty() || password?.text.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "empty input", Toast.LENGTH_LONG)
                    .show()
            } else {

                Toast.makeText(applicationContext, "En cours ...", Toast.LENGTH_LONG)
                    .show()
                var loginActivity = LoginRepo.Companion
                when (userType) {
                    0 -> {
                        loginActivity.loginDoctor(this,phoneNumber.text.toString(),password.text.toString())

                    }
                    1 -> {
                        loginActivity.loginPatient(this,phoneNumber.text.toString(),password.text.toString())

                    }
                    else -> { // Note the block
                        print("Un erreur c'est produit from login page")
                    }
                }
             /*   pref.edit {
                    putBoolean(
                        "connected", true
                    )
                }
                pref.edit {
                    putInt(
                        "typeUser", 0
                    )
                }*/

            }

        }
        //show and hide password 1
        ivShowHidePass.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(password, ivShowHidePass, mIsShowPass)
        }
        showPassword(password, ivShowHidePass, mIsShowPass)
    }

    /*fun checkPermission(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),1111)
        }else{
            finish()
        }
    }*/
    fun showPassword(a: EditText, b: ImageView, isShow: Boolean) {
        if (isShow) {
            // To show the password
            a.transformationMethod = HideReturnsTransformationMethod.getInstance()
            b.setImageResource(R.drawable.ic_hide_passsword)
        } else {
            // To hide the password
            a.transformationMethod = PasswordTransformationMethod.getInstance()
            b.setImageResource(R.drawable.ic_opend_eye)
        }
        // This line of code to put the pointer at the end of the password string
        a.setSelection(a.text.toString().length)
    }
}