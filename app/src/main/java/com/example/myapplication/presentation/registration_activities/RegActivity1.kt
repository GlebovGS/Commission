package com.example.myapplication.presentation.registration_activities
import android.app.ActivityOptions
import androidx.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityReg1Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityReg1Binding

    private val reg1VM by viewModel<Reg1ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReg1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        reg1VM.validationResult1.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextPersonName.error = it.errorMassage
            }
        })
        reg1VM.validationResult2.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextPersonLastName.error = it.errorMassage
            }
        })
        reg1VM.validationResult3.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextPersonPatronymic.error = it.errorMassage
            }
        })

        binding.btnNext.setOnClickListener{
            val userName = binding.editTextPersonName.text.toString().trim()
            val userLastName = binding.editTextPersonLastName.text.toString().trim()
            val userPatronymic = binding.editTextPersonPatronymic.text.toString().trim()
            reg1VM.save(userName,userLastName,userPatronymic)

            if(binding.editTextPersonLastName.error==null&&
                binding.editTextPersonName.error==null&&
                binding.editTextPersonPatronymic.error==null)
            {
                val intent = Intent(this, RegActivity2::class.java)
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}