package com.app.newstestapp.news

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.app.newstestapp.R
import com.app.newstestapp.api.API_KEY
import com.app.newstestapp.api.ApiClient.apiInterface
import com.app.newstestapp.base.BaseViewModel
import com.app.newstestapp.model.News
import com.app.newstestapp.model.NewsArticles
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel : BaseViewModel() {
    var newsLiveDataList: MutableLiveData<MutableList<NewsArticles>> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()
    fun requestNewsWithPosition(position: Int, mContext: Context) {
        val titlesArray = mContext.resources?.getStringArray(R.array.tabTitles)
        val singleObserver: Single<News>? =
            titlesArray?.get(position)?.let { apiInterface.requestTopNewsContent(API_KEY, it) }
        singleObserver?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : SingleObserver<News> {
                override fun onSuccess(newsList: News) {
                    newsLiveDataList.value = newsList.articles
                    isApiSuccess.value = true
                }

                override fun onSubscribe(disposable: Disposable) {
                    compositeDisposable.add(disposable)
                }

                override fun onError(e: Throwable) {
                    isApiSuccess.value = false
                }

            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}