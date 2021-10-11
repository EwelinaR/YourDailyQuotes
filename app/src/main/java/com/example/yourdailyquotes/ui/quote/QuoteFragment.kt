package com.example.yourdailyquotes.ui.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.yourdailyquotes.R

class QuoteFragment : Fragment() {

    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        quoteViewModel =
                ViewModelProvider(this).get(QuoteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quote, container, false)
        val textView: TextView = root.findViewById(R.id.text_quote)
        quoteViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }
}