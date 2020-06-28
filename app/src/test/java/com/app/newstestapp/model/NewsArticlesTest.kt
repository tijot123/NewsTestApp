package com.app.newstestapp.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NewsArticlesTest {
    private val newsArticles: NewsArticles by lazy {
        NewsArticles(
            "author",
            "title",
            "description",
            "url",
            "urlToImage",
            "publishedAt",
            "content"
        )
    }

    @Test
    fun getTitle() {
        assertEquals("title", newsArticles.title)
    }

    @Test
    fun setTitle() {
    }

    @Test
    fun getDescription() {
        assertEquals("description", newsArticles.description)
    }

    @Test
    fun setDescription() {
    }

    @Test
    fun getUrlToImage() {
        assertEquals("urlToImage", newsArticles.urlToImage)
    }

    @Test
    fun setUrlToImage() {
    }

    @Test
    fun getPublishedAt() {
        assertEquals("publishedAt", newsArticles.publishedAt)
    }

    @Test
    fun setPublishedAt() {
    }
}