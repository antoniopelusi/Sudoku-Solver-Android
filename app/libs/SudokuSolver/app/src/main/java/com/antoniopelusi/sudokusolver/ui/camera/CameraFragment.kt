package com.antoniopelusi.sudokusolver.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.antoniopelusi.sudokusolver.R
import com.antoniopelusi.sudokusolver.databinding.FragmentCameraBinding
import com.antoniopelusi.sudokusolver.ui.manual.ManualFragment
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null

    private val binding get() = _binding!!

    private lateinit var scanButton: Button

    private lateinit var rawArray: CharArray

    private var board = Array(9) { IntArray(9) }

    private fun qrReader(): Boolean
    {
        val options = GmsBarcodeScannerOptions.Builder().setBarcodeFormats(Barcode.FORMAT_QR_CODE).enableAutoZoom().build()
        val scanner = GmsBarcodeScanning.getClient(requireContext(), options)

        var out = false

        scanner.startScan()
            .addOnSuccessListener{
                barcode -> val rawValue: String? = barcode.rawValue

                if (rawValue != null)
                {
                    rawArray = rawValue.toCharArray()

                    for((k, i) in (0 until 9).withIndex())
                    {
                        for(j in 0 until 9)
                        {
                            board[i][j] = rawArray[j+k].code
                        }
                    }
                }
                out = true
            }
        return out
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
            if(qrReader())
            {
              Toast.makeText(context, "NAVIGATE", Toast.LENGTH_SHORT).show()

                findNavController().navigate(R.id.navigation_manual)
// TODO: GOOGLE LENS NON ASPETTA IL RISULTATO PRIMA DI AVVIARE IL FRAGMENT

                //val mf = ManualFragment()
                //mf.writeBoard(board)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}