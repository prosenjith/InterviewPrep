package com.example.interviewprep.ui.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    init {
        setData("Prosenjith")
    }

    private fun setData(name: String) {
        _name.value = name
    }
}