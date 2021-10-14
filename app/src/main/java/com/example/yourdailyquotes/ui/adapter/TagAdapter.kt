package com.example.yourdailyquotes.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yourdailyquotes.databinding.ItemTagBinding
import com.example.yourdailyquotes.model.Tag
import com.example.yourdailyquotes.ui.tags.TagListFragmentDirections

class TagAdapter(private val tags: Array<Tag>) : RecyclerView.Adapter<TagAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemTagBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTagBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            binding.name.text = tags[position].name
            binding.colorBox.setBackgroundColor(Color.parseColor(tags[position].color))
            itemView.setOnClickListener {
                val action = TagListFragmentDirections.actionNavTagsToNavListQuote(binding.name.text as String)
                Navigation.findNavController(itemView).navigate(action)
            }
        }
    }

    override fun getItemCount() = tags.size
}
