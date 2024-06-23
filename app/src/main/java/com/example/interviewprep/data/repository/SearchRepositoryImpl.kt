package com.example.interviewprep.data.repository

import com.example.interviewprep.data.model.SearchResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor() : SearchRepository {
    private val cache = mutableMapOf<String, List<SearchResult>>()

    override suspend fun fetchSearchResults(query: String): Flow<List<SearchResult>> {
        return flow {
            val cachedResult = cache[query]
            val searchResult: List<SearchResult>
            if (cachedResult == null) {
                searchResult = fetchSearchResultsFromApi(query)
                cache[query] = searchResult
            } else {
                searchResult = cachedResult
            }
            emit(searchResult)
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun fetchSearchResultsFromApi(query: String): List<SearchResult> {
        delay(2000)
        val dummyResults = listOf(
            SearchResult("Title 1", "Description 1"),
            SearchResult("Title 2", "Description 2"),
            SearchResult("Title 3", "Description 3"),
            SearchResult("Title 4", "Description 4"),
            SearchResult("Title 5", "Description 5"),
            SearchResult("Title 6", "Description 6"),
            SearchResult("Title 7", "Description 7"),
            SearchResult("Title 8", "Description 8"),
            SearchResult("Title 9", "Description 9"),
            SearchResult("Title 10", "Description 10")
        )
        val filteredResult = dummyResults.filter {
            it.title.contains(query, ignoreCase = true) ||
                    it.description.contains(query, ignoreCase = true)
        }
        return filteredResult
    }
}