package com.example.interviewprep.data.repository

import com.example.interviewprep.data.model.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun fetchSearchResults(query: String): Flow<List<SearchResult>>
}