package com.example.pet_books.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.pet_books.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val booksList = binding.searchRecycleView
        binding.searchQuery.doOnTextChanged { query, start, before, count ->
            if (binding.searchQuery.hasFocus() && query.toString().isNotEmpty()) {
                showBlank(query.toString().isEmpty())
            }
            viewModel.onSearchQueryChange(query.toString())
        }
    }

    private fun showBlank(showDefaultPlaceholder: Boolean = true) {
        with(binding) {
            searchRecycleView.isVisible = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}