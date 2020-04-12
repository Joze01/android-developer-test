package com.hugoapp.adt.presentation.parking

import androidx.databinding.ObservableField
import com.hugoapp.adt.R
import com.hugoapp.adt.presentation.base.BaseViewModel
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents
import com.hugoapp.data.util.resourceManage

class MainViewModel(private val resourceManage: resourceManage) : BaseViewModel() {

    val appBarTitleObservableField =
        ObservableField(resourceManage.getString(R.string.home_appbar_tittle))

    val backButtonVisible = ObservableField(false)

    fun backButtonClick() {
        fragmentNavigationObservable.value = Event(FragmentNavigationEvents.BACK)
    }
}