package com.app.newstestapp.detail

import android.widget.ImageView
import android.widget.TextView
import androidx.test.rule.ActivityTestRule
import com.app.newstestapp.R
import com.app.newstestapp.api.KEY_ITEM
import com.app.newstestapp.model.NewsArticles
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class NewsDetailsActivityAndroidTest {
    @get:Rule
    val newsDetailsActivityRule: ActivityTestRule<NewsDetailsActivity> by lazy {
        ActivityTestRule<NewsDetailsActivity>(NewsDetailsActivity::class.java)
    }

    private val mContext: NewsDetailsActivity by lazy {
        newsDetailsActivityRule.activity
    }

    @Before
    fun setUp() {


    }

    @After
    fun tearDown() {
    }


    @Test
    fun performActivityLaunch() {
        val view = mContext.findViewById<ImageView>(R.id.imageView)
        assertNotNull(view)
        val titleView = mContext.findViewById<TextView>(R.id.title)
        assertNotNull(titleView)
        val description = mContext.findViewById<TextView>(R.id.description)
        assertNotNull(description)


    }
}