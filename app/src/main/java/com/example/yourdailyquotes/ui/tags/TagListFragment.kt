package com.example.yourdailyquotes.ui.tags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.yourdailyquotes.databinding.FragmentTagsBinding
import com.example.yourdailyquotes.model.Tag
import com.example.yourdailyquotes.ui.adapter.TagAdapter

class TagListFragment : Fragment() {

    private lateinit var tagListViewModel: TagListViewModel
    private var _binding: FragmentTagsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        tagListViewModel = ViewModelProvider(this).get(TagListViewModel::class.java)
        _binding = FragmentTagsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO temporary mock data from db
        val tags =  arrayOf(Tag("favourite", "#FF2196F3"),
            Tag("motivation", "#FFCDDC39"))

        binding.tagListItems.adapter = TagAdapter(tags)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}