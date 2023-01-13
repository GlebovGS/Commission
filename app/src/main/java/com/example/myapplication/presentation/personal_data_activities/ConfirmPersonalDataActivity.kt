package com.example.myapplication.presentation.personal_data_activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityConfirmPersonalDataBinding
import com.example.myapplication.presentation.addition_documents_activities.AdditionPhotoActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConfirmPersonalDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmPersonalDataBinding

    val confirmPersonalDataVM by viewModel<ConfirmPersonalDataViewModel>()


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmPersonalDataBinding.inflate(layoutInflater)
        confirmPersonalDataVM.get()
        setContentView(binding.root)


        confirmPersonalDataVM.Citizenship.observe(this, Observer {
            binding.textViewCitizenship.text = it
        })
        confirmPersonalDataVM.INN.observe(this, Observer {
            binding.textViewINN.text = it
        })
        confirmPersonalDataVM.LearningLanguage.observe(this, Observer {
            binding.textViewLearningLanguage.text = it
        })
        confirmPersonalDataVM.NeedHostel.observe(this, Observer {
            if (it)
                binding.textViewNeedHostel.text = "Требуется"
            else
                binding.textViewNeedHostel.text = "Не требуется"
        })
        confirmPersonalDataVM.SameAddress.observe(this, Observer {
            if (it)
                binding.textViewTheSameAddress.text = "Адреса совпадают"
            else
                binding.textViewTheSameAddress.text = "Адреса не совпадают"
        })
        confirmPersonalDataVM.ListAddressR.observe(this, Observer {
            binding.textViewAddressR.text =
                "${it[0]}, ${it[1]} область, ${it[2]} район, ул. ${it[3]}, д.${it[4]}, кв.${it[5]}, индекс: ${it[6]}"
        })
        confirmPersonalDataVM.ListAddressP.observe(this, Observer {
            binding.textViewAddressP.text =
                "${it[0]}, ${it[1]} область, ${it[2]} район, ул. ${it[3]}, д.${it[4]}, кв.${it[5]}, индекс: ${it[6]}"
        })

        confirmPersonalDataVM.ListFatherData.observe(this, Observer {
            binding.textViewFatherFIO.text = "${it[0]} ${it[1]} ${it[2]}"
            binding.textViewFatherPhone.text = it[3]
            binding.textViewFatherAddress.text = it[4]
        })
        confirmPersonalDataVM.ListMotherData.observe(this, Observer {
            binding.textViewMotherFIO.text = "${it[0]} ${it[1]} ${it[2]}"
            binding.textViewMotherPhone.text = it[3]
            binding.textViewMotherAddress.text = it[4]
        })

        binding.btnNext.setOnClickListener{
            val intent = Intent(this, AdditionPhotoActivity::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}
