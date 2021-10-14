package com.example.yourdailyquotes.ui.quote

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.yourdailyquotes.R
import com.example.yourdailyquotes.databinding.FragmentQuoteBinding

class QuoteFragment : Fragment() {

    private val args: QuoteFragmentArgs by navArgs()
    private lateinit var quoteViewModel: QuoteViewModel
    private var _binding: FragmentQuoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        quoteViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
        _binding = FragmentQuoteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textQuote.text = args.quoteName
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        activity?.window?.statusBarColor = ContextCompat.getColor(this.requireContext(), R.color.black)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}