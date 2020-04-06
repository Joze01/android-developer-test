package com.sacredvalley.util.preference

import com.sacredvalley.util.preference.base.BasePreference
import com.sacredvalley.util.preference.base.Preference

class UserPreference : BasePreference(
    Preference.initializedContext(),
    USER_PREF
) {
    companion object {
        private const val USER_PREF = "USER_PREF"
    }
}