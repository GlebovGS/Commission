package com.example.myapplication.presentation.addition_documents_activities

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAdditionDocumentsBinding
import com.example.myapplication.presentation.navigationActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdditionDocumentsActivity : AppCompatActivity(),IDocumentsInfoAdapter {

    private val addDocVM by viewModel<AdditionDocumentsViewModel>()

    private lateinit var binding: ActivityAdditionDocumentsBinding
    private lateinit var layoutManager: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<DocumentsInfoAdapter.DocumentHolder>

    private var fileType:String = ""
    private var filesSize:Double = 0.0

    @SuppressLint("NotifyDataSetChanged", "SetTextI18n"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdditionDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.AddDocumentsRW.layoutManager = LinearLayoutManager(this)
        //binding.AddDocumentsRW.adapter = DocumentsInfoAdapter(documentsList)
        binding.imageViewHelp.setOnClickListener{
            helpWindow()
        }

        addDocVM.documentListLiveData.observe(this) {
            binding.AddDocumentsRW.adapter = DocumentsInfoAdapter(it, this)
            binding.AddDocumentsRW.adapter?.notifyDataSetChanged()
            var i = 0
            var filesSize = 0.0
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
            val intent = Intent(this, navigationActivity::class.java)
            startActivity(intent)
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
        val helpWindow = layoutInflater.inflate(R.layout.documents_info_window,null)
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

    override fun deleteDocument(position: Int) {
        addDocVM.deleteDocumentFromList(position)
    }
}












//package com.example.myapplication.presentation.addition_documents_activities
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.content.Intent
//import android.database.Cursor
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.provider.OpenableColumns
//import android.view.View
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.databinding.ActivityAdditionDocumentsBinding
//
//class AdditionDocumentsActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityAdditionDocumentsBinding
//    private lateinit var layoutManager: RecyclerView
//    private lateinit var adapter: RecyclerView.Adapter<DocumentsInfoAdapter.DocumentHolder>
//
//    val documentsList : MutableList<String> = mutableListOf()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityAdditionDocumentsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.AddDocumentsRW.layoutManager = LinearLayoutManager(this)
//        binding.AddDocumentsRW.adapter = DocumentsInfoAdapter(documentsList as ArrayList<String>)
//    }
//
//    // Функции в которых задаем параметры для intent, разница в type
//    private fun selectPdf() {
//        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
//        pdfIntent.type = "application/pdf"
//        pdfIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
//        resultLauncher.launch(pdfIntent)
//    }
//    private fun selectJpgPng(){
//        val jpgPngIntent = Intent(Intent.ACTION_GET_CONTENT)
//        jpgPngIntent.type = "image/*"
//        jpgPngIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//        jpgPngIntent.addCategory(Intent.CATEGORY_OPENABLE)
//        resultLauncher.launch(jpgPngIntent)
//    }
//
//    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//
//            val data: Intent? = result.data
//            if (data?.clipData != null) {
//                val count = data.clipData?.itemCount
//                for (i in 0 until count!!) {
//                    val documentUri: Uri = data.clipData?.getItemAt(i)!!.uri
//                    addDocumentToList(documentUri)
//                }
//            }
//            else if (data?.data != null) {
//                val documentUri: Uri = data.data!!
//                addDocumentToList(documentUri)
//            }
//        }
//    }
//
//    fun pickPDF(view: View){
//        selectPdf()
//    }
//
//    fun pickJpgPng(view: View) {
//        selectJpgPng()
//    }
//
//    @SuppressLint("Range")
//    fun addDocumentToList(documentUri: Uri){
//        val documentString: String = documentUri.toString()
//        var documentName: String? = null
//        if (documentString.startsWith("content://")) {
//            var myCursor: Cursor? = null
//            try {
//                myCursor = applicationContext!!.contentResolver.query(documentUri, null, null, null, null)
//                if (myCursor != null && myCursor.moveToFirst()) {
//                    documentName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                    documentsList.add(documentName)
//                    binding.AddDocumentsRW.adapter?.notifyItemChanged(documentsList.size-1)
//                }
//            } finally {
//                myCursor?.close()
//            }
//        }
//    }
//
//    fun goNext(view: View){
//        //val intent = Intent(this, PersonalDataActivity2::class.java)
//        //startActivity(intent)
//    }
//
//    fun goBack(view: View){
//        finish()
//    }
//}



