package com.example.yourdailyquotes.ui.tags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TagListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is list of quotes grouped by tags Fragment"
    }
    val text: LiveData<String> = _text
}