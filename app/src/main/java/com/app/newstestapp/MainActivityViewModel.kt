package com.app.newstestapp

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.app.newstestapp.api.API_KEY
import com.app.newstestapp.api.ApiClient.apiInterface
import com.app.newstestapp.api.COUNTRY
import com.app.newstestapp.base.BaseViewModel
import com.app.newstestapp.model.News
import com.app.newstestapp.model.NewsArticles
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel : BaseViewModel() {
    var headLinesLiveData: MutableLiveData<String> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun requestTopHeadlines() {
        val singleObserver: Single<News>? = apiInterface.requestTopHeadlines(API_KEY, COUNTRY)
        singleObserver?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : SingleObserver<News> {
                override fun onSuccess(newsList: News) {
                    doConcatenationOfHeadlines(newsList.articles)
                }

                override fun onSubscribe(disposable: Disposable) {
                    compositeDisposable.add(disposable)
                }

                override fun onError(e: Throwable) {
                    isApiSuccess.value = false
                }

            })
    }

    private fun doConcatenationOfHeadlines(articles: MutableList<NewsArticles>) {
        var headLines = ""
        for (i in articles.indices) {
            headLines = if (i == 0) articles[i].title
            else headLines + "    " + articles[i].title
        }

        if (!TextUtils.isEmpty(headLines)) {
            headLinesLiveData.value = headLines
            isApiSuccess.value = true
        } else isApiSuccess.value = false
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}