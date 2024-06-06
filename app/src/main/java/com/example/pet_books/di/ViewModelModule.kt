package com.example.pet_books.di

import com.example.pet_books.ui.home.LibraryViewModel
import com.example.pet_books.ui.notifications.EBooksViewModel
import com.example.pet_books.ui.search.SearchViewModel
import com.example.pet_books.ui.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        SearchViewModel()
    }
    viewModel {
        LibraryViewModel()
    }
    viewModel {
        EBooksViewModel()
    }
    viewModel {
        SettingsViewModel()
    }
}