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
import com.example.myapplication.presentation.navigation_fragments.Navigation
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ApplicationFormActivity2 : AppCompatActivity(),IPriorityAdapter {

    var documentNumber = 0
    var educationForm = "?"
    var course = 1  //TODO Как определяется курс?
    var faculty = "?"
    var cipher = "?"
    var specialityTitle = "?"
    private var profile = "Не указан"
    var priority = 0
    var count = 0 // Сколько всего создано приоритетов (максимум 6 на 2 документа)

    lateinit var binding: ActivityApplicationForm2Binding
    lateinit var speciality: Speciality

    val specialitiesList = mutableListOf<UserPriority>()
    val documentsList = listOf("Документ №1", "Документ №2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplicationForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SpecialitiesRW.layoutManager = LinearLayoutManager(this)
        binding.SpecialitiesRW.adapter = PriorityAdapter(this, specialitiesList,this)

        binding.spinnerSelectDocument.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.spinnerSelectDocument.setSelection(p2)
                documentNumber = p2+1
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        binding.spinnerSelectDocument.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, documentsList)

        binding.btnAddSpeciality.setOnClickListener{
            if (count>=6){
                showDialog("Нельзя добавить больше 6 приоритетов. Чтобы добавить новый, удалите какой-нибудь из существующих.")
            }else{
                dialogAddPriority()
            }
        }
        binding.btnNext.setOnClickListener {
            val priorities = mutableListOf<Int>()
            val profiles = mutableListOf<String>()
            for(speciality in specialitiesList){
                priorities.add(speciality.priority)
            }
            for(speciality in specialitiesList){
                profiles.add(speciality.profile)
            }
            val duplicatePrioritiesList = priorities.groupingBy { it }.eachCount().filter { it.value > 1 }
            val duplicateProfilesList = profiles.groupingBy { it }.eachCount().filter { it.value > 1 }
            if(count==0)
            {
                showDialog("Ни одно из направлений подготовки не выбрано!")
            }else{
                if(duplicatePrioritiesList.isEmpty()){
                    if(duplicateProfilesList.isEmpty()){
                        val intent = Intent(this, Navigation::class.java)
                        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                    }else{
                        showDialog("Направления подготовки не могут повторяться!")
                    }
                }else{
                    showDialog("Обнаружены одинаковые приоритеты! Распределите приоритеты так, чтобы они не повторялись.")
                }
            }
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
        val priorities = arrayListOf(1,2,3,4,5,6)

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
            specialitiesList.add(UserPriority(documentNumber,educationForm,course,faculty,cipher,profile,specialityTitle,priority))
            binding.SpecialitiesRW.adapter?.notifyItemChanged(specialitiesList.size-1)
            count++
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
            specialityTitle = speciality.specialityTitle
            profile = "${speciality.specialityTitle}($title)"
            faculty = speciality.facultyTitle
            cipher = speciality.specialityCipher
            dialog.dismiss()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun deletePriority(position: Int) {
        count--
        specialitiesList.removeAt(position)
        binding.SpecialitiesRW.adapter?.notifyItemRemoved(position)
    }

    override fun updatePriority(position: Int, newPriority: Int) {
        specialitiesList[position].priority = newPriority
    }

    private fun showDialog(message: String){
        MaterialAlertDialogBuilder(this)
            .setTitle("Ошибка")
            .setMessage(message)
            .setPositiveButton("ОК"){_,_-> }
            .show()
    }
}