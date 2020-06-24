package com.app.newstestapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.newstestapp.api.ApiClient
import com.app.newstestapp.api.ApiInterface

open class BaseViewModel : ViewModel() {
    var apiInterface: ApiInterface? = null
    var isApiSuccess: MutableLiveData<Boolean> = MutableLiveData()

    fun getApiInterfaceImplementation() {
        apiInterface = ApiClient.getClient()?.create(ApiInterface::class.java)
    }
}