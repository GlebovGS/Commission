package com.example.myapplication.presentation.navigation_fragments.information

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.myapplication.R

class FacultyAdapter(private val facultyList : List<FacultyInfo>,private val listener: IFacultyAdapter):
    RecyclerView.Adapter<FacultyAdapter.FacultyHolder>() {

    class FacultyHolder(item:View): RecyclerView.ViewHolder(item) {

        val textViewFacultyTitle: TextView = item.findViewById(R.id.textViewFacultyTitle)
        val btnEmailFaculty: Button = item.findViewById(R.id.btn_email_faculty)
        val btnEmailPkFaculty: Button = item.findViewById(R.id.btn_email_pk_faculty)
        val btnSiteFaculty: Button = item.findViewById(R.id.btn_site_faculty)
        val btnPhoneFaculty: Button = item.findViewById(R.id.btn_phone_faculty)
        val faculties_rw_item: CardView = item.findViewById(R.id.faculties_rw_item)
        val layout_more_information: ConstraintLayout= item.findViewById(R.id.layout_more_information)
        val image_expand_more: ImageView = item.findViewById(R.id.image_expand_more)
        val imageFacultyLogo: ImageView = item.findViewById(R.id.image_faculty_logo)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FacultyHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.faculties_rw, p0,false)
        return FacultyHolder(view)
    }

    override fun onBindViewHolder(p0: FacultyHolder, p1: Int) {

        p0.textViewFacultyTitle.text = facultyList[p1].name

        p0.imageFacultyLogo.setImageResource(facultyList[p1].logo)

        p0.btnEmailFaculty.setOnClickListener {
            listener.goToLink(facultyList[p1].email,1)
        }

        p0.btnEmailPkFaculty.setOnClickListener {
            listener.goToLink(facultyList[p1].emailPk,1)
        }

        p0.btnSiteFaculty.setOnClickListener {
            listener.goToLink(facultyList[p1].site,2)
        }

        p0.btnPhoneFaculty.setOnClickListener {
            listener.goToLink(facultyList[p1].phone1,3)
        }

        p0.faculties_rw_item.setOnClickListener {
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
    }

    override fun getItemCount(): Int {
        return facultyList.size
    }

}

interface IFacultyAdapter{
    fun goToLink(p0:String,p1:Int)
}