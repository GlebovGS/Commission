package com.example.myapplication.presentation.navigation_fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentChatWithOperatorBinding


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatWithOperatorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DashboardViewModel::class.java]

        binding = FragmentChatWithOperatorBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}