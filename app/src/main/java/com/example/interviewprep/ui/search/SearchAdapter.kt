package com.example.interviewprep.ui.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewprep.R
import com.example.interviewprep.data.model.SearchResult

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val data = mutableListOf<SearchResult>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = data[position]
        holder.title.text = result.title
        holder.description.text = result.description
    }

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<SearchResult>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}
