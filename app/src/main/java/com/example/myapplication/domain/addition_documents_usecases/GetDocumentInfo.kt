package com.example.myapplication.domain.addition_documents_usecases

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import com.example.myapplication.R
import com.example.myapplication.presentation.URIPathHelper
import com.example.myapplication.presentation.addition_documents_activities.DocumentsInfo
import java.io.File

class GetDocumentInfo(private val appContext: Context){

    @SuppressLint("Range")
    fun getInfo(documentUri: Uri): DocumentsInfo {

        val uriPathHelper = URIPathHelper()
        val filePath = uriPathHelper.getPath(appContext, documentUri)
        val fileSize: Double= File(filePath!!).length() / 1024.0/ 1024.0
        var documentTitle = ""
        var documentImage = R.drawable.unknownfile
        val documentString: String = documentUri.toString()

        if (documentString.startsWith("content://")) {
            var myCursor: Cursor? = null
            try {
                myCursor = appContext.contentResolver.query(documentUri, null, null, null, null)
                if (myCursor != null && myCursor.moveToFirst()) {
                    documentTitle = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))

                    if(documentTitle.endsWith(".pdf")){
                        documentImage = R.drawable.iconpdf
                    }else if(documentTitle.endsWith(".jpg")){
                        documentImage = R.drawable.iconjpg
                    }else if(documentTitle.endsWith(".png")){
                        documentImage = R.drawable.iconpng
                    }
                }
            } finally {
                myCursor?.close()
            }
        }
        println(filePath)
        return DocumentsInfo(documentTitle,filePath,fileSize,documentImage)
    }
}