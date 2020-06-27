package com.app.newstestapp.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.app.newstestapp.news.NewsFragment

class TabsAdapter(fm: FragmentManager, private val titleArray: Array<String>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment = NewsFragment.newInstance(position)

    override fun getCount(): Int = titleArray.count()

    override fun getPageTitle(position: Int): CharSequence? = titleArray[position]
}