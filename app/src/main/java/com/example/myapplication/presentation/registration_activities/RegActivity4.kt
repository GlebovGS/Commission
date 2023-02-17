package com.example.myapplication.presentation.registration_activities

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityReg4Binding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class RegActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivityReg4Binding

    private val reg4VM by viewModel<Reg4ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReg4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        reg4VM.validationResult1.observe(this) {
            if (it.errorMassage != null) {
                binding.editTextUserEmail.error = it.errorMassage
            }
        }
        reg4VM.validationResult2.observe(this) {
            if (it.errorMassage != null) {
                binding.editTextUserNumberPhone.error = it.errorMassage
            }
        }

        binding.btnNext.setOnClickListener{
            val userEmail = binding.editTextUserEmail.text.toString().trim()
            val userPhone = binding.editTextUserNumberPhone.text.toString().trim()
            val userOtherContacts = binding.editTextUserOtherContacts.text.toString().trim()

            reg4VM.save(userEmail,userPhone,userOtherContacts)

            if(binding.editTextUserEmail.error==null&&
                binding.editTextUserNumberPhone.error==null&&
                binding.editTextUserOtherContacts.error==null)
            {
                binding.textView2.text = "4/4"
                binding.progressBarRegistration.progress = 100
                captchaDialog()
            }
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }

    private fun goNext(){
        val intent = Intent(this, ConfirmRegActivity::class.java)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }


    @SuppressLint("InflateParams", "SetTextI18n")
    private fun captchaDialog(){
        val dialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_captcha,null)
        val answer = dialogLayout.findViewById<EditText>(R.id.editTextCaptcha)
        val example = dialogLayout.findViewById<TextView>(R.id.TextViewCaptcha)
        val number1 = Random.nextInt(-10,10)
        val number2 = Random.nextInt(-10,10)
        val number3 = Random.nextInt(-10,10)
        val result = number1+number2+number3
        with(dialog){
            setTitle("Решите простой пример")
            example.text = "$number1 + $number2 + $number3 ="
            setPositiveButton("Готово"){ _, _ ->
                if(answer.text.isNotBlank() && answer.text.trim().toString().toInt()==result)
                {
                    goNext()
                }
                else
                {
                    Toast.makeText(applicationContext, "Неверно!", Toast.LENGTH_LONG).show()
                    binding.textView2.text = "3/4"
                    binding.progressBarRegistration.progress = 75
                }
            }
            setView(dialogLayout)
            show()
        }
    }
}