package com.antoniopelusi.sudokusolver.ui.camera

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.antoniopelusi.sudokusolver.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val REQUEST_CODE = 200

    private lateinit var imageView: ImageView
    private lateinit var button: Button

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            isGranted: Boolean -> if (isGranted){
        // Permission Accepted
        makeText(activity, "Permission Accepted.", LENGTH_SHORT).show()
    }
    else {
        // Permission Denied
        makeText(activity, "Permission Denied.", LENGTH_SHORT).show()
    }
    }

    private fun capturePhoto() {
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
        {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, REQUEST_CODE)
        }
        else makeText(activity, "Camera is necessary to add content.", LENGTH_SHORT).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    Manifest.permission.CAMERA)
            }
        }

        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val root: View = binding.root

        imageView = binding.clickImage

        button = binding.cameraButton
        button.setOnClickListener {
            capturePhoto()
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){
            imageView.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    
}