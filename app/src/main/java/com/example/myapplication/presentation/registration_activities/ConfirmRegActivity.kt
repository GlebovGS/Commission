package com.example.myapplication.presentation.registration_activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityConfirmRegBinding
import com.example.myapplication.presentation.personal_data_activities.PersonalDataActivity1
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConfirmRegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmRegBinding

    val confirmRegVM by viewModel<ConfirmRegViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmRegBinding.inflate(layoutInflater)

        confirmRegVM.get()

        confirmRegVM.fio.observe(this) {
            binding.textViewFIO.text = it
        }
        confirmRegVM.date.observe(this) {
            binding.textViewDate.text = it
        }
        confirmRegVM.login.observe(this) {
            binding.textViewLogin.text = it
        }
        confirmRegVM.email.observe(this) {
            binding.textViewEmail.text = it
        }
        confirmRegVM.phone.observe(this) {
            binding.textViewNumberPhone.text = it
        }
        confirmRegVM.contacts.observe(this) {
            binding.textViewContacts.text = it
        }

        binding.textViewID.text = "[Будет сообщен позже]"
        binding.textViewIDphoto.text = "[Будет сообщен позже]"

        setContentView(binding.root)

        binding.btnNext.setOnClickListener{
            val intent = Intent(this, PersonalDataActivity1::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}