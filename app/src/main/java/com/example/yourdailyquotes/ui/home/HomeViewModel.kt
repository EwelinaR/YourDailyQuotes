package com.example.yourdailyquotes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _quote = MutableLiveData<String>().apply {
        value = "The best hardcoded quote ever. You are the best!"
    }
    val quote: LiveData<String> = _quote

    private val _source = MutableLiveData<String>().apply {
        value = "Anonim"
    }
    val source: LiveData<String> = _source
}