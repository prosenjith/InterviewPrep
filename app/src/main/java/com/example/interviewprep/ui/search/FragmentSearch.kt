package com.example.interviewprep.ui.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewprep.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentSearch : Fragment(R.layout.fragment_search) {

    private val viewModel by viewModels<SearchViewModel>()
    private val searchAdapter by lazy { SearchAdapter() }

    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        observeData()
    }

    @OptIn(FlowPreview::class)
    private fun setupViews(view: View) {
        searchView = view.findViewById(R.id.searchView)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = searchAdapter

        val searchFlow = callbackFlow {
            val queryTextListener = object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let { trySend(it).isSuccess }
                    return true
                }
            }
            searchView.setOnQueryTextListener(queryTextListener)
            awaitClose { searchView.setOnQueryTextListener(null) }
        }

        lifecycleScope.launch {
            searchFlow
                .debounce(300L) // wait for 300 milliseconds pause in typing
                .distinctUntilChanged() // only proceed if the query has changed
                .filter { query ->
                    return@filter query.isNotEmpty() // filter out empty queries
                }
                .collect { query ->
                    viewModel.fetchSearchResults(query)
                }
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.searchResults.collect {
                        searchAdapter.setData(it)
                    }
                }
            }
        }
    }
}