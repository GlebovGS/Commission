package com.example.myapplication.presentation.addition_documents_activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.addition_documents_usecases.GetDocumentInfoUseCase

@SuppressLint("StaticFieldLeak")
class AdditionDocumentsViewModel(private val context:Context):ViewModel() {

    private val documentListMut = MutableLiveData<List<DocumentsInfo>>()
    private val documentsList : MutableList<DocumentsInfo> = mutableListOf()

    val documentListLiveData: LiveData<List<DocumentsInfo>> = documentListMut

    fun addDocumentsInfoToList(data:Intent?){
        if (data?.clipData != null) {

            val count = data.clipData?.itemCount
            for (i in 0 until count!!) {
                val documentUri: Uri = data.clipData?.getItemAt(i)!!.uri
                val getDocument = GetDocumentInfoUseCase(context)
                val document = getDocument.getInfo(documentUri)
                documentsList.add(document)
                documentListMut.value = documentsList
            }
        }
        else if (data?.data != null) {

            val documentUri: Uri = data.data!!
            val getDocument = GetDocumentInfoUseCase(context)
            val document = getDocument.getInfo(documentUri)
            documentsList.add(document)
            documentListMut.value = documentsList
        }
    }

    fun deleteDocumentFromList(position:Int){
        documentsList.removeAt(position)
        documentListMut.value = documentsList
    }
}