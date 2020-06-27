package com.app.newstestapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.newstestapp.api.KEY_ITEM
import com.app.newstestapp.databinding.ActivityMainBinding
import com.app.newstestapp.detail.NewsDetailsActivity
import com.app.newstestapp.model.NewsArticles
import com.app.newstestapp.news.NewsDataClickListener
import com.app.newstestapp.tabs.TabsAdapter

class MainActivity : AppCompatActivity(), NewsDataClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setUpTabs()
        setUpHeadlines()
    }

    private fun setUpHeadlines() {
        viewModel.headLinesLiveData.observe(this, Observer {
            binding.headLinesInfo = it
        })
        viewModel.isApiSuccess.observe(this, Observer {
            binding.shouldShowHeadlines = it
        })

        viewModel.requestTopHeadlines()
    }

    private fun setUpTabs() {
        val titles = resources?.getStringArray(R.array.tabTitles)
        val mTabsAdapter = titles?.let { TabsAdapter(supportFragmentManager, it) }
        binding.pager.adapter = mTabsAdapter
        binding.tabs.setupWithViewPager(binding.pager)
    }

    override fun onDataClicked(news: NewsArticles) {
        val intent = Intent(this, NewsDetailsActivity::class.java)
        intent.putExtra(KEY_ITEM, news)
        startActivity(intent)
    }


}