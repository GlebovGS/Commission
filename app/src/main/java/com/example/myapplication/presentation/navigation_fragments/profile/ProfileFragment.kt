package com.example.myapplication.presentation.navigation_fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {


    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val fragmentProfileVM by viewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentProfileVM.getName()
        fragmentProfileVM.getPhoto()

        fragmentProfileVM.user_name.observe(viewLifecycleOwner) {
            binding.textViewProfileName.text = it
        }

        fragmentProfileVM.user_photo.observe(viewLifecycleOwner) {
            binding.ImageViewProfilePhoto.setImageBitmap(it)
        }

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}