package com.example.myapplication.presentation.navigation_fragments.information

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.FragmentInfoBinding

class NotificationsFragment : Fragment(),IFacultyAdapter {

    lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentInfoBinding.inflate(inflater, container, false)
        init()
        return binding.root

    }

    private fun init() = with(binding){
        facultyRefsView.layoutManager=
            LinearLayoutManager(this@NotificationsFragment.context)
        facultyRefsView.setHasFixedSize(true)
        facultyRefsView.adapter = FacultyAdapter(facultyList,this@NotificationsFragment)
    }


    override fun goToLink(p0: String, p1: Int) {

        if(p1==1){
            val email = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", p0,null))
            startActivity(Intent.createChooser(email,"Открыть"))
        }else if(p1==2){
            val site = Intent(Intent.ACTION_VIEW, Uri.parse(p0))
            this@NotificationsFragment.context?.let { ContextCompat.startActivity(it, site, null) }
        }else if(p1==3){
            val phone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$p0"))
            this@NotificationsFragment.context?.let { ContextCompat.startActivity(it, phone, null) }
        }

    }
}
