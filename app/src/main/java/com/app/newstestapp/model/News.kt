package com.app.newstestapp.model

data class News(
    var status: String,
    var totalResults: Int,
    var articles: MutableList<NewsArticles>
)

data class NewsArticles(
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String
)