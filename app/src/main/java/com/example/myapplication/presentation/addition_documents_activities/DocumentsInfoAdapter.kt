package com.example.myapplication.presentation.addition_documents_activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class DocumentsInfoAdapter(private val documentsList: List<DocumentsInfo>,
                           private val listener:IDocumentsInfoAdapter):
    RecyclerView.Adapter<DocumentsInfoAdapter.DocumentHolder>() {


    class DocumentHolder(item:View): RecyclerView.ViewHolder(item) {
        val textViewDocumentId = item.findViewById<TextView>(R.id.documentId)
        val imageViewDocumentType = item.findViewById<ImageView>(R.id.documentImage)
        val textViewDocumentTitle = item.findViewById<TextView>(R.id.documentTitle)
        val imageViewdeleteDocument = item.findViewById<ImageView>(R.id.documentDelete)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DocumentHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.user_documents_rw, p0,false)
        return DocumentHolder(view)
    }

    override fun onBindViewHolder(p0: DocumentHolder, p1: Int) {
        p0.textViewDocumentId.text = (p1+1).toString()
        p0.textViewDocumentTitle.text = documentsList[p1].DocumentTitle
        p0.imageViewDocumentType.setImageResource(documentsList[p1].DocumentImage)
        p0.imageViewdeleteDocument.setOnClickListener {

            listener.deleteDocument(p1)
        }
    }

    override fun getItemCount(): Int {
        return documentsList.size
    }
}

interface IDocumentsInfoAdapter{
    fun deleteDocument(position:Int)
}