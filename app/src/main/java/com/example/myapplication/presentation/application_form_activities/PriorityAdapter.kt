package com.example.myapplication.presentation.application_form_activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.addition_documents_activities.IDocumentsInfoAdapter

class PriorityAdapter(private val list:MutableList<UserPriority>, private val listener: IPriorityAdapter):
    RecyclerView.Adapter<PriorityAdapter.SpecialtiesHolder>() {

    class SpecialtiesHolder(item:View):RecyclerView.ViewHolder(item) {

        val documentNumber = item.findViewById<TextView>(R.id.textViewDocumentNumber)
        val educationForm = item.findViewById<TextView>(R.id.textViewEducationForm)
        val course = item.findViewById<TextView>(R.id.textViewCourse)
        val faculty = item.findViewById<TextView>(R.id.textViewFaculty)
        val cipher = item.findViewById<TextView>(R.id.textViewCipher)
        val profile = item.findViewById<TextView>(R.id.textViewProfile)
        val priority = item.findViewById<TextView>(R.id.textViewPriority)

        val layout_more_information: LinearLayout = item.findViewById(R.id.layout_expand_more_document_information)
        val image_expand_more: ImageView = item.findViewById(R.id.image_expand_more_document_information)
        val imageViewDeletePriority: Button = item.findViewById(R.id.btn_priority_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtiesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_priorities_rw, parent,false)
        return SpecialtiesHolder(view)
    }

    override fun onBindViewHolder(p0: SpecialtiesHolder, p1: Int) {
        val speciality = list[p1]
        p0.documentNumber.text = speciality.documentNumber.toString()
        p0.educationForm.text = speciality.educationForm
        p0.course.text = speciality.course.toString()
        p0.faculty.text = speciality.faculty
        p0.cipher.text = speciality.cipher
        p0.profile.text = speciality.profile
        p0.priority.text = speciality.priority.toString()

        p0.image_expand_more.setOnClickListener {
            if (p0.layout_more_information.isVisible)
            {
                p0.layout_more_information.isVisible = false
                p0.image_expand_more.setImageResource(R.drawable.ic_baseline_expand_more_24)
            }
            else{
                p0.layout_more_information.isVisible = true
                p0.image_expand_more.setImageResource(R.drawable.ic_baseline_expand_less_24)
            }
        }

        p0.imageViewDeletePriority.setOnClickListener {
            listener.deletePriority(p1)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface IPriorityAdapter{
    fun deletePriority(position:Int)
}