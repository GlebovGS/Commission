package com.example.myapplication.presentation.application_form_activities

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityApplicationForm2Binding


class ApplicationFormActivity2 : AppCompatActivity() {

    var documentNumber = 0
    var educationForm = "?"
    var course = 1  //TODO Как определяется курс?
    var faculty = "?"
    var cipher = "?"
    private var profile = "Не указан"
    var priority = 0

    lateinit var binding: ActivityApplicationForm2Binding
    lateinit var speciality: Speciality

    val specialitiesList = mutableListOf<UserPriority>()
    val documentsList = listOf("Документ №1", "Документ №2")

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplicationForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SpecialitiesRW.layoutManager = LinearLayoutManager(this)
        binding.SpecialitiesRW.adapter = PriorityAdapter(specialitiesList)

        binding.spinnerSelectDocument.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.spinnerSelectDocument.setSelection(p2)
                documentNumber = p2+1
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        binding.spinnerSelectDocument.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, documentsList)

        binding.btnAddSpeciality.setOnClickListener{
            dialogAddPriority()
        }
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, ApplicationFormActivity1::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        binding.btnBack.setOnClickListener {
            finish()
        }

    }

    @SuppressLint("InflateParams", "NotifyDataSetChanged")
    private fun dialogAddPriority(){
        val dialogWindow = layoutInflater.inflate(R.layout.dialog_add_speciality,null)
        val dialog = Dialog(this)

        val btnSelect = dialogWindow.findViewById<Button>(R.id.btn_select_speciality)
        val btnOK = dialogWindow.findViewById<Button>(R.id.btn_dialog_ok)

        val educationForms = arrayListOf("Очная","Заочная","Очно-заочная")
        val priorities = arrayListOf(1,2,3)

        val selectEducationForm = dialogWindow.findViewById<Spinner>(R.id.spinner1)
        val selectPriority = dialogWindow.findViewById<Spinner>(R.id.spinner2)

        selectEducationForm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectEducationForm.setSelection(p2)
                educationForm = educationForms[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        selectEducationForm.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, educationForms)

        selectPriority.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectPriority.setSelection(p2)
                priority = priorities[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        selectPriority.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, priorities)

        dialog.setContentView(dialogWindow)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.show()

        btnSelect.setOnClickListener{
            dialogSelectSpeciality()
        }

        btnOK.setOnClickListener{
            specialitiesList.add(UserPriority(documentNumber,educationForm,course,faculty,cipher,profile,priority))
            binding.SpecialitiesRW.adapter?.notifyDataSetChanged()
            dialog.dismiss()
        }
    }

    private fun dialogSelectSpeciality() {
        val dialogWindow = layoutInflater.inflate(R.layout.dialog_select_speciality,null)
        val dialog = Dialog(this)
        val btnOK = dialogWindow.findViewById<Button>(R.id.btn_OK)


        dialog.setContentView(dialogWindow)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.show()

        btnOK.setOnClickListener {
            val selectedRB = dialogWindow.findViewById<RadioGroup>(R.id.radioGroupSpecialities).checkedRadioButtonId

            val select = dialogWindow.findViewById<RadioButton>(selectedRB)

            title = select.text.toString()


            try {
                speciality = specialityList1.first { it.profiles.any { it==title } }
            }
            catch (e: NoSuchElementException) {
                speciality = specialityList1.first { it.specialityTitle == title }
                title = "профиль не указан"
            }

            profile = "${speciality.specialityTitle}($title)"
            faculty = speciality.facultyTitle
            cipher = speciality.specialityCipher

            dialog.dismiss()
        }
    }

}