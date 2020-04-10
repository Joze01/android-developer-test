package com.hugoapp.adt.util.preference

import com.hugoapp.adt.util.preference.base.BasePreference
import com.hugoapp.adt.util.preference.base.Preference

class SessionPreferences : BasePreference(
    Preference.initializedContext(),
    SESSION_PREF
) {

    companion object {
        private const val USER_SESSION = "USER_SESSION"
        private const val SESSION_PREF = "SESSION_PREF"
    }

    var activeSession
        set(value) = putBoolean(USER_SESSION, value)
        get() = getBoolean(USER_SESSION, false)
}