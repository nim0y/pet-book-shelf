package com.example.pet_books.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_books.ui.state.SearchScreenState
import com.example.pet_books.utils.Constants
import com.example.pet_books.utils.debounce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _searchState = MutableLiveData<SearchScreenState>()
    val searchState: LiveData<SearchScreenState> = _searchState
    val actionStateFlow = MutableSharedFlow<String>()
    private var found: Int? = null
    var lastQuery: String? = null

    fun onSearchQueryChange(query: String?) {
        searchDebounce(query?.trim())
    }

    private val searchDebounce =
        debounce<String?>(Constants.SEARCH_DEBOUNCE_DELAY, viewModelScope, true) { query ->
            viewModelScope.launch(Dispatchers.IO) {
                if (query?.isNotEmpty() == true && query != lastQuery) {
                    found = null
                    lastQuery = query
                    setState(SearchScreenState.Loading)
                    actionStateFlow.emit(query)
                } else if (query?.trim() == lastQuery?.trim() && query?.isNotEmpty() == true) {
                    val state = _searchState.value
                    if (state != null) {
                        setState(SearchScreenState.Default)
                        _searchState.postValue(state)
                    }
                }
            }
        }

    private fun setState(state: SearchScreenState) {
        _searchState.postValue(state)
    }
}