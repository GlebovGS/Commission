package com.example.myapplication.presentation.personal_data_activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityPersonalData2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonalDataActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalData2Binding

    private val personalData2VM by viewModel<PersonalData2ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalData2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        personalData2VM.validationResult1.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserLocalityR.error = it.errorMassage
            }
        })
        personalData2VM.validationResult2.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserRegionR.error = it.errorMassage
            }
        })
        personalData2VM.validationResult3.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserDistrictR.error = it.errorMassage
            }
        })
        personalData2VM.validationResult4.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserStreetR.error = it.errorMassage
            }
        })
        personalData2VM.validationResult5.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserHouseR.error = it.errorMassage
            }
        })
//        personalData2VM.validationResult6.observe(this, Observer{
//            if (it.errorMassage != null) {
//                binding.editTextUserFlatR.error = it.errorMassage
//            }
//        })
        personalData2VM.validationResult6.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserIndexR.error = it.errorMassage
            }
        })

        personalData2VM.validationResult7.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserLocalityP.error = it.errorMassage
            }
        })
        personalData2VM.validationResult8.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserRegionP.error = it.errorMassage
            }
        })
        personalData2VM.validationResult9.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserDistrictP.error = it.errorMassage
            }
        })
        personalData2VM.validationResult10.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserStreetP.error = it.errorMassage
            }
        })
        personalData2VM.validationResult11.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserHouseP.error = it.errorMassage
            }
        })
//        personalData2VM.validationResult6.observe(this, Observer{
//            if (it.errorMassage != null) {
//                binding.editTextUserFlatR.error = it.errorMassage
//            }
//        })
        personalData2VM.validationResult12.observe(this, Observer{
            if (it.errorMassage != null) {
                binding.editTextUserIndexP.error = it.errorMassage
            }
        })

        binding.btnNext.setOnClickListener{
            goNext()
        }

        binding.btnBack.setOnClickListener{
            finish()
        }

    }

    fun goNext(){

        val sameAddress = binding.checkBoxTheSameAddress.isChecked

        val localityR = binding.editTextUserLocalityR.text.toString().trim()
        val regionR = binding.editTextUserRegionR.text.toString().trim()
        val districtR = binding.editTextUserDistrictR.text.toString().trim()
        val streetR = binding.editTextUserStreetR.text.toString().trim()
        val houseR = binding.editTextUserHouseR.text.toString().trim()
        val flatR = binding.editTextUserFlatR.text.toString().trim()
        val indexR = binding.editTextUserIndexR.text.toString().trim()

        val localityP = binding.editTextUserLocalityP.text.toString().trim()
        val regionP = binding.editTextUserRegionP.text.toString().trim()
        val districtP = binding.editTextUserDistrictP.text.toString().trim()
        val streetP = binding.editTextUserStreetP.text.toString().trim()
        val houseP = binding.editTextUserHouseP.text.toString().trim()
        val flatP = binding.editTextUserFlatP.text.toString().trim()
        val indexP = binding.editTextUserIndexP.text.toString().trim()

        val needHostel = binding.checkBoxNeedHostel.isChecked

        personalData2VM.validate(sameAddress,localityR,regionR,districtR,streetR,houseR,flatR,indexR,
            localityP,regionP,districtP,streetP,houseP,flatP,indexP,needHostel)

        if( binding.editTextUserLocalityR.error==null&&
            binding.editTextUserRegionR.error==null&&
            binding.editTextUserDistrictR.error==null&&
            binding.editTextUserStreetR.error==null&&
            binding.editTextUserHouseR.error==null&&
            binding.editTextUserFlatR.error==null&&
            binding.editTextUserIndexR.error==null) {

            if(!sameAddress) {

                if( binding.editTextUserLocalityP.error==null&&
                    binding.editTextUserRegionP.error==null&&
                    binding.editTextUserDistrictP.error==null&&
                    binding.editTextUserStreetP.error==null&&
                    binding.editTextUserHouseP.error==null&&
                    binding.editTextUserFlatP.error==null&&
                    binding.editTextUserIndexP.error==null)
                {
                    personalData2VM.save(sameAddress,localityR,regionR,districtR,streetR,houseR,flatR,indexR,
                        localityP,regionP,districtP,streetP,houseP,flatP,indexP,needHostel)
                    val intent = Intent(this, PersonalDataActivity3::class.java)
                    startActivity(intent)
                }
            }
            else{
                personalData2VM.save(sameAddress,localityR,regionR,districtR,streetR,houseR,flatR,indexR,
                    localityP,regionP,districtP,streetP,houseP,flatP,indexP,needHostel)

                val intent = Intent(this, PersonalDataActivity3::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
        }
    }
}