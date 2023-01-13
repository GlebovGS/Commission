package com.example.myapplication.presentation.ui.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentInfoBinding


class NotificationsFragment : Fragment() {

    lateinit var binding: FragmentInfoBinding
    private lateinit var newArrayList : ArrayList<facultyInfo>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        imageId = arrayOf(
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,
            R.drawable.f5,
            R.drawable.f6,
            R.drawable.f7,
            R.drawable.f8,
            R.drawable.f9,
            R.drawable.f10
        )
        heading = arrayOf(
            "Горный факультет",
            "Институт инновационных технологий заочного обучения",
            "Инженерно-экономический факультет",
            "Факультет интегрированных и мехатронных производств",
            "Факультет интеллектуальных систем и программирования",
            "Факультет информационных систем и технологий",
            "Факультет интеллектуальной электроэнергетики и робототехники",
            "Факультет компьютерных информационных технологий и автоматики",
            "Факультет металлургии и теплоэнергетики",
            "Факультет недропользования и наук о земле"
        )

        binding = FragmentInfoBinding.inflate(inflater, container, false)

        init()
        return binding.root

    }

    private fun init() = with(binding){
        facultyRefsView.layoutManager=
            LinearLayoutManager(this@NotificationsFragment.context)
        facultyRefsView.setHasFixedSize(true)
        newArrayList = arrayListOf()
        for(i in imageId.indices){
            newArrayList.add(facultyInfo(imageId[i],heading[i]))
        }
        facultyRefsView.adapter = facultyAdapter(newArrayList)
        textView9.movementMethod = LinkMovementMethod.getInstance();
    }

}