package com.example.myapplication.presentation.addition_documents_activities

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.myapplication.databinding.ActivityAdditionPhotoBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdditionPhotoActivity : AppCompatActivity() {

    private val addPhotoVM by viewModel<AdditionPhotoViewModel>()

    private lateinit var binding: ActivityAdditionPhotoBinding

    var flag = 0

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdditionPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addPhotoVM.user_photo.observe(this) {
            binding.imageUserPhoto.setImageBitmap(it)
            flag = 1
        }

        binding.btnNext.setOnClickListener{

            if(flag==1){
                val intent = Intent(this, AdditionDocumentsActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }else{
                showDialog()
            }

        }

        binding.imageUserPhoto.setOnClickListener{
            pickPhoto()
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun pickPhoto(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        resultLauncher.launch(intent)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val documentUri: Intent? = result.data
            addPhotoVM.imageBitmap(documentUri)
        }
    }

    private fun showDialog(){
        MaterialAlertDialogBuilder(this)
            .setTitle("Ошибка")
            .setMessage("Вы не выбрали фото")
            .setPositiveButton("ОК"){_,_-> }
            .show()
    }
}



//            if(Build.VERSION.SDK_INT>=28){
//                val sourse = ImageDecoder.createSource(this.contentResolver, pickedPhoto)
//                binding.imageUserPhoto.setImageBitmap(ImageDecoder.decodeBitmap(sourse))
//            }
//            else{
//                val imageBitMap = MediaStore.Images.Media.getBitmap(this.contentResolver,pickedPhoto)
//                binding.imageUserPhoto.setImageBitmap(imageBitMap)
//            }