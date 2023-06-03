package com.example.myapplication.presentation.application_form_activities

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class PriorityAdapter(private val context:Context, private val list:MutableList<UserPriority>, private val listener: IPriorityAdapter):
    RecyclerView.Adapter<PriorityAdapter.SpecialtiesHolder>() {

    val priorities = arrayListOf(1,2,3,4,5,6)

    class SpecialtiesHolder(item:View):RecyclerView.ViewHolder(item) {

        val documentTitle = item.findViewById<TextView>(R.id.textViewDocumentTitle)
        val documentNumber = item.findViewById<TextView>(R.id.textViewDocumentNumber)
        val educationForm = item.findViewById<TextView>(R.id.textViewEducationForm)
        val course = item.findViewById<TextView>(R.id.textViewCourse)
        val faculty = item.findViewById<TextView>(R.id.textViewFaculty)
        val cipher = item.findViewById<TextView>(R.id.textViewCipher)
        val profile = item.findViewById<TextView>(R.id.textViewProfile)
        val priority = item.findViewById<Spinner>(R.id.spinnerSelectPriority2)

        val layout_more_information: LinearLayout = item.findViewById(R.id.layout_expand_more_document_information)
        val image_expand_more: ImageView = item.findViewById(R.id.image_expand_more_document_information)
        val imageViewDeletePriority: Button = item.findViewById(R.id.btn_priority_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtiesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_priorities_rw, parent,false)
        return SpecialtiesHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: SpecialtiesHolder, @SuppressLint("RecyclerView") pos: Int) {
        val speciality = list[pos]
        var spinnerCount = 0
        p0.documentTitle.text = "№ ${pos+1}"
        p0.documentNumber.text = speciality.documentNumber.toString()
        p0.educationForm.text = speciality.educationForm
        p0.course.text = speciality.course.toString()
        p0.faculty.text = speciality.faculty
        p0.cipher.text = speciality.cipher
        p0.profile.text = speciality.profile

        p0.priority.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p1: AdapterView<*>?, p2: View?, p3: Int, p4: Long) {

                if (spinnerCount == 0)
                {
                    spinnerCount++
                    p0.priority.setSelection(speciality.priority-1)
                }
                else
                {
                    p0.priority.setSelection(p3)
                    listener.updatePriority(pos,p3)
                }

                if (p1 != null) {
                    (p1.getChildAt(0) as TextView).setTextColor(Color.YELLOW)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        p0.priority.adapter = ArrayAdapter(context.applicationContext,
            android.R.layout.simple_list_item_1,priorities)


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
            listener.deletePriority(pos)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

    interface IPriorityAdapter{
        fun deletePriority(position:Int)
        fun updatePriority(position:Int,newPriority:Int)
    }