package com.app.newstestapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    var isApiSuccess: MutableLiveData<Boolean> = MutableLiveData()
}