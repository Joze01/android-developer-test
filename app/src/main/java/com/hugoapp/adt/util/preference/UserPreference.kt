package com.hugoapp.adt.util.preference

import com.hugoapp.adt.util.preference.base.BasePreference
import com.hugoapp.adt.util.preference.base.Preference

class UserPreference : BasePreference(
    Preference.initializedContext(),
    USER_PREF
) {
    companion object {
        private const val USER_PREF = "USER_PREF"
    }
}