package com.example.pet_books.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pet_books.databinding.FragmentSettingsBinding
import com.example.pet_books.ui.search.SearchViewModel

class SettingsFragment:Fragment() {
    private var _binding : FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            val searchViewModel =
                ViewModelProvider(this)[SearchViewModel::class.java]

            _binding = FragmentSettingsBinding.inflate(inflater, container, false)
            val root: View = binding.root

            return root
    }
}