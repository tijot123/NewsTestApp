package com.app.newstestapp.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.newstestapp.R
import com.app.newstestapp.databinding.NewsFragmentBinding

class NewsFragment : Fragment() {

    companion object {
        private const val POSITION = "position"
        fun newInstance(position: Int): Fragment {
            val bundle = Bundle()
            bundle.putInt(POSITION, position)
            val newsFragment = NewsFragment()
            newsFragment.arguments = bundle
            return newsFragment
        }
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var binding: NewsFragmentBinding

    private var currentPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { currentPosition = it.getInt(POSITION, 0) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.news_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.requestNewsWithPosition(currentPosition)
    }

}