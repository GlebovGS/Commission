package com.example.myapplication.presentation.application_form_activities
import android.R
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityApplicationForm1Binding


class ApplicationFormActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityApplicationForm1Binding

    val based_education = arrayListOf("Сред. общ.","Сред. проф.","Бакалавр","Специалист")
    var education_programs = arrayListOf("")
    var education_programs2 = arrayListOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApplicationForm1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner для первого документа
        binding.spinnerBasedEducation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.spinnerBasedEducation.setSelection(p2)
                when(p2){
                    0 -> education_programs = arrayListOf("Бакалавр","Специалист")
                    1 -> education_programs = arrayListOf("Бакалавр","Специалист")
                    2 -> education_programs = arrayListOf("Магистр")
                    3 -> education_programs = arrayListOf("Магистр")
                }
                addToSpinner(education_programs)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        binding.spinnerBasedEducation.adapter = ArrayAdapter(this,R.layout.simple_list_item_1,based_education)

        binding.spinnerEducationProgram.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.spinnerEducationProgram.setSelection(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }


        // Spinner для второго документа
        binding.spinnerBasedEducation2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.spinnerBasedEducation2.setSelection(p2)
                when(p2){
                    0 -> education_programs2 = arrayListOf("Бакалавр","Специалист")
                    1 -> education_programs2 = arrayListOf("Бакалавр","Специалист")
                    2 -> education_programs2 = arrayListOf("Магистр")
                    3 -> education_programs2 = arrayListOf("Магистр")
                }
                addToSpinner2(education_programs2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        binding.spinnerBasedEducation2.adapter = ArrayAdapter(this,R.layout.simple_list_item_1,based_education)

        binding.spinnerEducationProgram2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.spinnerEducationProgram2.setSelection(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.btnAddDocument.setOnClickListener {
            if (binding.document2.isVisible)
            {
                binding.document2.isVisible = false
                binding.btnAddDocument.text = "Добавить второй документ"
            }
            else{
                binding.document2.isVisible = true
                binding.btnAddDocument.text = "Не добавлять второй документ"
            }


        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, ApplicationFormActivity2::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
   }



    private fun addToSpinner(educationPrograms: ArrayList<String>) {
        binding.spinnerEducationProgram.adapter = ArrayAdapter(this,R.layout.simple_list_item_1,education_programs)
    }
    private fun addToSpinner2(educationPrograms: ArrayList<String>) {
        binding.spinnerEducationProgram2.adapter = ArrayAdapter(this,R.layout.simple_list_item_1,education_programs2)
    }


}