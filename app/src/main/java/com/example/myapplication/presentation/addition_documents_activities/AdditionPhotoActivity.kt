package com.example.myapplication.presentation.addition_documents_activities

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityAdditionPhotoBinding

class AdditionPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdditionPhotoBinding
    var pickedPhoto: Uri? = null
    private var pitkedBitMap: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdditionPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnNext.setOnClickListener{
            val intent = Intent(this, AdditionDocumentsActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        binding.imageUserPhoto.setOnClickListener{
            pickPhoto()
        }
    }

    fun pickPhoto(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        resultLauncher.launch(intent)

//        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
//        != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)}
//        else{
//            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            resultLauncher.launch(intent)
//            }
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if(requestCode==1){
//            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                val intent= Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//                resultLauncher.launch(intent)
//            }
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//    }

    private fun imageBitmap(pickedPhoto: Uri?){
        if(pickedPhoto!=null){
            if(Build.VERSION.SDK_INT>=28){
                val sourse = ImageDecoder.createSource(this.contentResolver, pickedPhoto)
                binding.imageUserPhoto.setImageBitmap(ImageDecoder.decodeBitmap(sourse))
            }
            else{
                pitkedBitMap = MediaStore.Images.Media.getBitmap(this.contentResolver,pickedPhoto)
                binding.imageUserPhoto.setImageBitmap(pitkedBitMap)
            }
        }
    }

    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val documentUri: Intent? = result.data
            val pickedPhoto: Uri? = documentUri?.data
            imageBitmap(pickedPhoto)
        }
    }
}
