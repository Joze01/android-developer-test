package com.hugoapp.data.util

import android.content.Context
import android.content.res.Resources
import androidx.annotation.StringRes

/**
 * Created by Jose Arteaga on 12/4/2019
 * Applaudo Studios
 *
 */
class resourceManage(context: Context) {
    private var manager: Resources = context.resources

    fun getString(@StringRes resourceId: Int): String = manager.getString(resourceId)
}