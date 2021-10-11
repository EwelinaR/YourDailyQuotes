package com.example.yourdailyquotes.ui.tags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.yourdailyquotes.R

class TagListFragment : Fragment() {

    private lateinit var tagListViewModel: TagListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tagListViewModel =
                ViewModelProvider(this).get(TagListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tags, container, false)
        val textView: TextView = root.findViewById(R.id.text_tags)
        tagListViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}