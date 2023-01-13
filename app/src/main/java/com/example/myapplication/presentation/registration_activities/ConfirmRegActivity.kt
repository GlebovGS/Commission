package com.example.myapplication.presentation.registration_activities
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.registration_repositories.UserContactsRepositoryImpl
import com.example.myapplication.data.registration_repositories.UserDateRepositoryImpl
import com.example.myapplication.data.registration_repositories.UserLoginPasswordRepositoryImpl
import com.example.myapplication.data.registration_repositories.UserNameRepositoryImpl
import com.example.myapplication.databinding.ActivityConfirmRegBinding
import com.example.myapplication.domain.registration_usecases.GetContactsUseCase
import com.example.myapplication.domain.registration_usecases.GetDateUseCase
import com.example.myapplication.domain.registration_usecases.GetLoginPaswordUseCase
import com.example.myapplication.domain.registration_usecases.GetNameUseCase
import com.example.myapplication.presentation.personal_data_activities.PersonalDataActivity1
import kotlin.random.Random

class ConfirmRegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmRegBinding

    private val userNameRepository by lazy { UserNameRepositoryImpl(context = applicationContext) }
    private val userDateRepository by lazy { UserDateRepositoryImpl(context = applicationContext) }
    private val userLoginRepository by lazy { UserLoginPasswordRepositoryImpl(context = applicationContext) }
    private val userContactsRepository by lazy { UserContactsRepositoryImpl(context = applicationContext) }

    private val get_name  by lazy {
        GetNameUseCase(userNameRepository)
    }
    private val get_date  by lazy {
        GetDateUseCase(userDateRepository)
    }
    private val get_login_password  by lazy {
        GetLoginPaswordUseCase(userLoginRepository)
    }
    private val get_contacts  by lazy {
        GetContactsUseCase(userContactsRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmRegBinding.inflate(layoutInflater)

        val userName = get_name.getName()
        val userLastname = get_name.getLastName()
        val userPatronymic = get_name.getPatronymic()
        val userDate = get_date.getDate()
        val userLogin = get_login_password.getlogin()
        val userNumberPhone = get_contacts.getPhoneNumber()
        val userEmail = get_contacts.getEmail()
        val userContacts = get_contacts.getOtherContacts()

        binding.textViewID.text = Random.nextInt(1, 100).toString() // Будет по-другому
        binding.textViewIDphoto.text = "[Будет сообщен позже]"
        binding.textViewFIO.text = "$userLastname $userName $userPatronymic"
        binding.textViewDate.text = userDate
        binding.textViewLogin.text = userLogin
        binding.textViewNumberPhone.text = userNumberPhone
        binding.textViewEmail.text = userEmail
        binding.textViewContacts.text = userContacts
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