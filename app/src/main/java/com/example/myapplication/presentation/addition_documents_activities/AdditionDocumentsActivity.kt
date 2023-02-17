package com.example.myapplication.presentation.addition_documents_activities

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAdditionDocumentsBinding
import com.example.myapplication.presentation.application_form_activities.ApplicationFormActivity1
import com.example.myapplication.presentation.navigation_fragments.Navigation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdditionDocumentsActivity : AppCompatActivity(),IDocumentsInfoAdapter {

    private val addDocVM by viewModel<AdditionDocumentsViewModel>()

    private lateinit var binding: ActivityAdditionDocumentsBinding
    private var fileType:String = ""
    private var filesSize = 0.0
    private var emptyFlag = 1

    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdditionDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.AddDocumentsRW.layoutManager = LinearLayoutManager(this)
        //binding.AddDocumentsRW.adapter = DocumentsInfoAdapter(addDocVM.documentListLiveData.value!!,this)
        binding.imageViewHelp.setOnClickListener{
            helpWindow()
        }

        addDocVM.documentListLiveData.observe(this) {
            emptyFlag = 0
            binding.AddDocumentsRW.isVisible = true
            binding.imageEmptyRW.isGone = true
            binding.textEmptyRW.isGone = true
            if(it.isEmpty())
            {
                emptyFlag = 1
                binding.AddDocumentsRW.isGone = true
                binding.imageEmptyRW.isVisible = true
                binding.textEmptyRW.isVisible = true
            }
            binding.AddDocumentsRW.adapter = DocumentsInfoAdapter(it, this)
            binding.AddDocumentsRW.adapter?.notifyDataSetChanged()
            var i = 0
            filesSize=0.0
            while (i < it.size) {
                filesSize += it[i].DocumentLength
                i++
            }
            if(filesSize>=100){
                binding.progressBarFileSize.setIndicatorColor(Color.parseColor("#93000A"))
                binding.textViewProgressBarValue.setTextColor(Color.rgb(220, 130, 59))
            }
            else{
                binding.progressBarFileSize.setIndicatorColor(Color.parseColor("#8CD88C"))
                binding.textViewProgressBarValue.setTextColor(Color.rgb(197, 224, 255))
            }
            binding.progressBarFileSize.setProgress(filesSize.toInt(), true)
            binding.textViewProgressBarValue.text = "Допустимый размер файлов: ${filesSize.toInt()} / 100 мегабайт"
        }

        binding.buttonLoadJPG.setOnClickListener{
            fileType = "image/*"
            selectDocument(fileType)
        }

        binding.buttonLoadPDF.setOnClickListener {
            fileType = "application/pdf"
            selectDocument(fileType)
        }

        binding.btnNext.setOnClickListener {
            if(emptyFlag==1)
            {
                showDialog("Вы не добавили ни одного файла!")
            }else if(filesSize>=100){
                showDialog("Вы превысили общий размер всех файлов!")
            }else{
                val intent = Intent(this, ApplicationFormActivity1::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun selectDocument(type:String){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = type
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        resultLauncher.launch(intent)
    }

    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            if (result.data!=null){
                val data: Intent? = result.data
                addDocVM.addDocumentsInfoToList(data)
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun helpWindow(){
        val helpWindow = layoutInflater.inflate(R.layout.dialog_add_documents_help,null)
        val dialog = Dialog(this)
        val button = helpWindow.findViewById<Button>(R.id.button_ok)
        dialog.setContentView(helpWindow)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.show()
        button.setOnClickListener{
            dialog.dismiss()
        }
    }

    private fun showDialog(message: String){
        MaterialAlertDialogBuilder(this)
            .setTitle("Ошибка")
            .setMessage(message)
            .setPositiveButton("ОК"){_,_-> }
            .show()
    }

    override fun deleteDocument(position: Int) {
        addDocVM.deleteDocumentFromList(position)
    }
}