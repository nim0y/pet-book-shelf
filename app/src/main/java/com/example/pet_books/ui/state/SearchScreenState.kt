package com.example.pet_books.ui.state

sealed interface SearchScreenState {
    data object Loading : SearchScreenState

    data object LoadNextPage : SearchScreenState

    data object Default : SearchScreenState

    data class NothingFound(

        val found: Int
    ) : SearchScreenState

    data class Success(

        val found: Int
    ) : SearchScreenState

    data object Error : SearchScreenState
}