package com.example.myapplication.presentation.ui.information

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FacultyInfBinding

class facultyAdapter(private val facultyList : ArrayList<facultyInfo>):
    RecyclerView.Adapter<facultyAdapter.facultyHolder>() {

    class facultyHolder(item:View): RecyclerView.ViewHolder(item) {
        val binding = FacultyInfBinding.bind(item)
        fun bind(info: facultyInfo) = with(binding){
            facultyimage.setImageResource(info.facultyId)
            facultytext.text = info.name
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): facultyHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.faculty_inf, p0,false)
        return facultyHolder(view)
    }

    override fun onBindViewHolder(p0: facultyHolder, p1: Int) {
        p0.bind(facultyList[p1])
    }

    override fun getItemCount(): Int {
        return facultyList.size
    }
}