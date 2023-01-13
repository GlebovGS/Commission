package com.example.myapplication.presentation.application_form_activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class PriorityAdapter(private val list:MutableList<UserPriority>):
    RecyclerView.Adapter<PriorityAdapter.SpecialtiesHolder>() {

    class SpecialtiesHolder(item:View):RecyclerView.ViewHolder(item) {

        val documentNumber = item.findViewById<TextView>(R.id.textViewDocumentNumber)
        val educationForm = item.findViewById<TextView>(R.id.textViewEducationForm)
        val course = item.findViewById<TextView>(R.id.textViewCourse)
        val faculty = item.findViewById<TextView>(R.id.textViewFaculty)
        val cipher = item.findViewById<TextView>(R.id.textViewCipher)
        val profile = item.findViewById<TextView>(R.id.textViewProfile)
        val priority = item.findViewById<TextView>(R.id.textViewPriority)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtiesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_priorities_rw, parent,false)
        return SpecialtiesHolder(view)
    }

    override fun onBindViewHolder(holder: SpecialtiesHolder, position: Int) {
        val speciality = list[position]
        holder.documentNumber.text = speciality.documentNumber.toString()
        holder.educationForm.text = speciality.educationForm
        holder.course.text = speciality.course.toString()
        holder.faculty.text = speciality.faculty
        holder.cipher.text = speciality.cipher
        holder.profile.text = speciality.profile
        holder.priority.text = speciality.priority.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}