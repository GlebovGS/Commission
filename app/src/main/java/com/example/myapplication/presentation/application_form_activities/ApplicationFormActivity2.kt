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
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.retrofit.RetrofitRepository
import com.example.myapplication.databinding.ActivityApplicationForm2Binding
import com.example.myapplication.presentation.navigation_fragments.Navigation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.*

class ApplicationFormActivity2 : AppCompatActivity(),IPriorityAdapter {

    private var documentNumber = 0
    private var educationForm = "?"
    private var course = 1  //TODO Как определяется курс?
    private var faculty = "?"
    private var cipher = "?"
    private var specialityTitle = "?"
    private var profile = "Не указан"
    private var priority = 0
    private var count = 0 // Сколько всего создано приоритетов (максимум 6 на 2 документа)

    private lateinit var specialitiesList1: List<SpecialityInfoModel>

    lateinit var binding: ActivityApplicationForm2Binding
    private lateinit var specialityInfoModel: SpecialityInfoModel

    private val specialitiesList = mutableListOf<UserPriority>()
    private val documentsList = listOf("Документ №1", "Документ №2")

    private val repository = RetrofitRepository()

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
                showDialog(getString(R.string.max_priorities_reached))
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
                showDialog(getString(R.string.no_specialization_selected))

            }else{
                if(duplicatePrioritiesList.isEmpty()){
                    if(duplicateProfilesList.isEmpty()){
                        val intent = Intent(this, Navigation::class.java)
                        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                    }else{
                        showDialog(getString(R.string.directions_cannot_repeat))
                    }
                }else{
                    showDialog(getString(R.string.same_priorities))
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

    @SuppressLint("InflateParams")
    private fun dialogSelectSpeciality() {
        val dialogWindow = layoutInflater.inflate(R.layout.dialog_select_speciality,null)
        val dialog = Dialog(this)

        dialog.setContentView(dialogWindow)
        val rgSpecialities = dialogWindow.findViewById<RadioGroup>(R.id.radioGroupSpecialities)
        val btnOK = dialogWindow.findViewById<Button>(R.id.btn_OK)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.show()

        getSpecialityList(rgSpecialities)

        btnOK.setOnClickListener {
            try {
                val selectedRB = rgSpecialities.checkedRadioButtonId

                val select = dialogWindow.findViewById<RadioButton>(selectedRB)

                title = select.text.toString()

                try {
                    specialityInfoModel = specialitiesList1.first { specialityItem ->
                        specialityItem.profiles.any { profileItem ->
                            profileItem == title
                        }
                    }
                }
                catch (e: NoSuchElementException) {
                    specialityInfoModel = specialitiesList1.first { it.specialityTitle == title }
                    title = "профиль не указан"
                }
                specialityTitle = specialityInfoModel.specialityTitle
                profile = "${specialityInfoModel.specialityTitle}($title)"
                faculty = specialityInfoModel.facultyTitle
                cipher = specialityInfoModel.specialityCipher
                dialog.dismiss()
            }catch (e:Exception){
                Toast.makeText(this, getString(R.string.nothing_selected), Toast.LENGTH_SHORT).show()
            }
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

    private fun getSpecialityList(rgSpecialities: RadioGroup) = runBlocking {
        launch(Dispatchers.IO) {
            try {
                specialitiesList1 = repository.getSpeciality().body()!!.results

                var i = 0
                while (i < specialitiesList1.size-1) {
                    if(i ==0 || specialitiesList1[i].facultyTitle != specialitiesList1[i-1].facultyTitle){
                        val tvFaculty = TextView(this@ApplicationFormActivity2)
                        tvFaculty.text = specialitiesList1[i].facultyTitle
                        val paramsTV = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        paramsTV.setMargins(16, 8, 24, 8)
                        tvFaculty.layoutParams = paramsTV
                        rgSpecialities.addView(tvFaculty)
                    }
                    val radioButtonS = RadioButton(this@ApplicationFormActivity2)
                    radioButtonS.text = specialitiesList1[i].specialityTitle

                    val paramsS = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    paramsS.setMargins(16, 8, 8, 0)
                    radioButtonS.layoutParams = paramsS

                    rgSpecialities.addView(radioButtonS)
                    for(j in specialitiesList1[i].profiles){
                        val radioButtonP = RadioButton(this@ApplicationFormActivity2)
                        radioButtonP.text = j

                        val paramsP = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        paramsP.setMargins(48, 8, 8, 0)
                        radioButtonP.layoutParams = paramsP

                        rgSpecialities.addView(radioButtonP)
                    }
                    i++
                }

            } catch (e: Exception) {
                println("Ошибка: ${e.message}")
            }
        }
    }
}