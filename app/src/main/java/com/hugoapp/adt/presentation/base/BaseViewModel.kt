package com.hugoapp.adt.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents

/**
 * Created by Jose Arteaga on 2019-11-11.
 * Applaudo Studios
 */
open class BaseViewModel : ViewModel() {
    // For Error Handling
    val snackBarError = MutableLiveData<Event<Int>>()

    val fragmentNavigationObservable = MutableLiveData<Event<FragmentNavigationEvents>>()

}