package com.antoniopelusi.sudokusolver.ui.camera

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.antoniopelusi.sudokusolver.ResultsActivity
import com.antoniopelusi.sudokusolver.databinding.FragmentCameraBinding
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null

    private val binding get() = _binding!!

    private lateinit var scanButton: Button

    private lateinit var rawArray: CharArray

    private var rawValue: String? = ""

    private var isComplete: Boolean = false

    private var board = Array(9) { IntArray(9) }

    private fun qrReader()
    {
        Thread {

            val options =
                GmsBarcodeScannerOptions.Builder().setBarcodeFormats(Barcode.FORMAT_QR_CODE)
                    .enableAutoZoom().build()
            val scanner = GmsBarcodeScanning.getClient(requireContext(), options)

            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    rawValue = barcode.rawValue

                    if (rawValue != null) {
                        rawArray = rawValue!!.toCharArray()

                        for ((k, i) in (0 until 9).withIndex()) {
                            for (j in 0 until 9) {
                                board[i][j] = rawArray[j + k].code
                            }
                        }
                    }
                    isComplete = true
                }.addOnCompleteListener {

                }.addOnFailureListener {

                }.addOnCanceledListener {

                }
        }.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val root: View = binding.root

        scanButton = binding.scanQr
        scanButton.setOnClickListener {
            qrReader()
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        if(isComplete)
        {
            val intent = Intent(activity, ResultsActivity::class.java)

            intent.putExtra("rawValue", rawValue)
            startActivity(intent)

            isComplete = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}