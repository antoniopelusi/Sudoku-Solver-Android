package com.antoniopelusi.sudokusolver.ui.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.antoniopelusi.sudokusolver.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val REQUEST_CODE = 200

    private lateinit var imageView: ImageView
    private lateinit var button: Button

    private fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cameraViewModel =
            ViewModelProvider(this)[CameraViewModel::class.java]

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