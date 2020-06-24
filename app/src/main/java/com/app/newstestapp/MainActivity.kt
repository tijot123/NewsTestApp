package com.app.newstestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.newstestapp.databinding.ActivityMainBinding
import com.app.newstestapp.tabs.TabsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpTabs()


    }

    private fun setUpTabs() {
        val titles = resources?.getStringArray(R.array.tabTitles)
        val mTabsAdapter = titles?.let { TabsAdapter(supportFragmentManager, it) }
        binding.pager.adapter = mTabsAdapter
        binding.tabs.setupWithViewPager(binding.pager)
    }
}