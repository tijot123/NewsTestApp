package com.app.newstestapp.news

import com.app.newstestapp.model.NewsArticles

interface NewsDataClickListener {
    fun onDataClicked(news: NewsArticles)
}