package com.example.yourdailyquotes.ui.quotelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yourdailyquotes.R
import com.example.yourdailyquotes.databinding.FragmentQuoteListBinding
import com.example.yourdailyquotes.model.Quote
import com.example.yourdailyquotes.ui.adapter.QuoteAdapter
import java.util.*

class QuoteListFragment : Fragment() {

    private val args: QuoteListFragmentArgs by navArgs()
    private lateinit var quoteListViewModel: QuoteListViewModel
    private var _binding: FragmentQuoteListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        quoteListViewModel = ViewModelProvider(this).get(QuoteListViewModel::class.java)
        _binding = FragmentQuoteListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO temporary mock data from db
        val quotes =  arrayOf(
            Quote(args.tagName, "anonymous", listOf(), "", Calendar.getInstance().time),
            Quote("motivational quote", "Mark Twain", listOf(), "", Calendar.getInstance().time)
        )

        val quoteAdapter = QuoteAdapter(quotes)

        val recyclerView = binding.quoteListItems
        recyclerView.adapter = quoteAdapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onResume() {
        super.onResume()
        activity?.window?.statusBarColor =
            ContextCompat.getColor(this.requireContext(), R.color.design_default_color_primary_dark)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}