package com.example.myapplication.presentation.registration_activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityReg2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class RegActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityReg2Binding

    private val reg2VM by viewModel<Reg2ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReg2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val datePicker = Calendar.getInstance()
        binding.datePicker.init(
            datePicker.get(Calendar.YEAR),
            datePicker.get(Calendar.MONTH),
            datePicker.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, day ->
            val month = month + 1
            val date = "$day.$month.$year"
            var saveResult = reg2VM.save(date)
        }

        binding.btnNext.setOnClickListener{
            val intent = Intent(this, RegActivity3::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}