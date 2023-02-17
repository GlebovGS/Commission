package com.example.myapplication.domain.addition_documents_usecases

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.OpenableColumns
import com.example.myapplication.R
import com.example.myapplication.presentation.addition_documents_activities.DocumentsInfo
import java.io.File
import java.io.FileOutputStream

class GetDocumentInfoUseCase(private val appContext: Context){

    @SuppressLint("Range")
    fun getInfo(documentUri: Uri): DocumentsInfo {

        var fileSize = 0.0
        var documentTitle = "Неизвестный файл"
        var documentImage = R.drawable.unknownfile

        val documentString: String = documentUri.toString()

        if (documentString.startsWith("content://")) {
            var myCursor: Cursor? = null
            try {
                myCursor = appContext.contentResolver.query(documentUri, null, null, null, null)
                if (myCursor != null && myCursor.moveToFirst()) {
                    documentTitle = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))

                    fileSize = getFileSize(documentUri,documentTitle)

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
        return DocumentsInfo(documentTitle,fileSize,documentImage)
    }

    private fun createFile(fileName: String): File {
        val storageDir = appContext.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        return  File(storageDir, fileName)
        //return File.createTempFile(fileName,".jpg",storageDir)
    }

    private fun getFileSize(documentUri:Uri,documentTitle:String): Double {
        appContext.contentResolver.openInputStream(documentUri)?.let {

            val tempFile:File = createFile(documentTitle)
            val fileOutputStream = FileOutputStream(tempFile)
            it.copyTo(fileOutputStream)
            it.close()
            fileOutputStream.close()

            val length = tempFile.length()
            return length /1024.0/1024.0
        }
        return 0.0
    }
}