package com.example.interviewprep.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewprep.data.model.SearchResult
import com.example.interviewprep.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository) :
    ViewModel() {

    private var searchJob: Job? = null

    private val _searchResults = MutableStateFlow<List<SearchResult>>(emptyList())
    val searchResults: StateFlow<List<SearchResult>> = _searchResults

    fun fetchSearchResults(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            searchRepository.fetchSearchResults(query)
                .collect {
                    _searchResults.value = it
                }
        }
    }
}