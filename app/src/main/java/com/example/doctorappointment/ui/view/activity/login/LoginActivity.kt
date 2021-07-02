package com.example.doctorappointment.ui.view.activity.login

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
import com.example.doctorappointment.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    var mIsShowPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        logIn.setOnClickListener {


            if (phoneNumber?.text.isNullOrEmpty() || password?.text.isNullOrEmpty() ) {
                Toast.makeText(applicationContext, "empty input", Toast.LENGTH_LONG)
                    .show()
            }else{
                Toast.makeText(applicationContext, "Good", Toast.LENGTH_LONG)
                    .show()
            }

        }
        //show and hide password 1
        ivShowHidePass.setOnClickListener {
            Toast.makeText(applicationContext, "Good", Toast.LENGTH_LONG)
                .show()
            mIsShowPass = !mIsShowPass
            showPassword(password, ivShowHidePass, mIsShowPass)
        }
        showPassword(password, ivShowHidePass, mIsShowPass)
    }
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