package com.example.yourdailyquotes.model

import java.util.Date

data class Quote(val quote: String, val source: String, val tags: List<Tag>, val note: String, val date: Date)