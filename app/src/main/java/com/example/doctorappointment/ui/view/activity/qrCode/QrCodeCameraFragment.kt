package com.example.doctorappointment.ui.view.activity.qrCode

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.example.doctorappointment.R
import java.util.jar.Manifest

class QrCodeCameraFragment : Fragment() {

    private lateinit var codeScanner: CodeScanner
    private  var permisse: Boolean =false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qr_code_camera, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()
        codeScanner = CodeScanner(activity, scannerView)
        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                Toast.makeText(activity, it.text, Toast.LENGTH_LONG).show()
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Information")
                builder.setMessage(it.text)

                builder.setPositiveButton("Ok") { dialog, which ->
                    Toast.makeText(context,
                        "Maybe", Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()

        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}