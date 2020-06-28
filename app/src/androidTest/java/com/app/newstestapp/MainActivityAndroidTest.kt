package com.app.newstestapp

import android.widget.TextView
import androidx.test.rule.ActivityTestRule
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityAndroidTest {
    @get:Rule
    val mainActivityRule: ActivityTestRule<MainActivity> by lazy {
        ActivityTestRule<MainActivity>(MainActivity::class.java)
    }

    private val mContext: MainActivity by lazy {
        mainActivityRule.activity
    }

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun performActivityLaunch() {
        val view = mContext.findViewById<TextView>(R.id.headLines)
        assertNotNull(view)
        val tabsView = mContext.findViewById<TabLayout>(R.id.tabs)
        assertNotNull(tabsView)
        val viewPager = mContext.findViewById<ViewPager>(R.id.pager)
        assertNotNull(viewPager)
    }

}