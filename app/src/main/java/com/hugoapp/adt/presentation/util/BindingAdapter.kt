package com.hugoapp.adt.presentation.util

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("visible")
    fun View.visible(visible: Boolean) {
        visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    @BindingAdapter("visibleOrGone")
    fun View.visibleOrGone(visible: Boolean) {
        visibility = if (visible) View.VISIBLE else View.GONE
    }
}