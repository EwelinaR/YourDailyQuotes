package com.example.yourdailyquotes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yourdailyquotes.databinding.ItemQuoteBinding
import com.example.yourdailyquotes.model.Quote
import com.example.yourdailyquotes.ui.quotelist.QuoteListFragmentDirections

class QuoteAdapter(private val quotes: Array<Quote>) : RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemQuoteBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            binding.quoteText.text = quotes[position].quote
            binding.quoteSource.text = quotes[position].source
            itemView.setOnClickListener {
                val action = QuoteListFragmentDirections.actionNavQuoteListToNavQuote(binding.quoteText.text as String)
                Navigation.findNavController(itemView).navigate(action)
            }
        }
    }

    override fun getItemCount() = quotes.size
}