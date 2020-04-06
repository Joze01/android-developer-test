package com.sacredvalley.util.preference.base

import android.content.Context
import android.util.AndroidRuntimeException
import android.util.Log
import android.util.SparseArray
import java.lang.ref.WeakReference

object Preference {

    private var preferences: SparseArray<BasePreference>? = null
    private var preferenceContext: WeakReference<Context>? = null

    fun with(context: Context) {
        if (preferenceContext == null || preferences == null) {
            preferenceContext = WeakReference(context)
            preferences = SparseArray()
        } else {
            Log.d(
                Preference::class.java.name,
                "Preference provider is already running")
        }
    }

    fun initializedContext(): Context {
        if (preferenceContext == null || preferences == null)
            throw AndroidRuntimeException("Preference manager is not running")
        return preferenceContext?.get()
            ?: throw AndroidRuntimeException("Context can't be null")
    }

    /**
     * Call getPreference to of your implementation of @BasePreference abstract class
     * @see BasePreference
     *
     * @return a new object created by calling the constructor
     * this object represents
     *
     * @exception IllegalAccessException if this {@code Constructor} object
     *              is enforcing Java language access control and the underlying
     *              constructor is inaccessible.
     * @exception IllegalArgumentException if the number of actual
     *              and formal parameters differ; if an unwrapping
     *              conversion for primitive arguments fails; or if,
     *              after possible unwrapping, a parameter value
     *              cannot be converted to the corresponding formal
     *              parameter type by a method invocation conversion; if
     *              this constructor pertains to an enum type.
     * @exception InstantiationException if the class that declares the
     *              underlying constructor represents an abstract class.
     *              throws an exception.
     * @exception ExceptionInInitializerError if the initialization provoked
     *              by this method fails.
     */
    @Suppress("UNCHECKED_CAST")
    fun <T : BasePreference> of(clazz: Class<T>): T {
        val hashCode = clazz.hashCode()

        preferences?.let { safePreferences ->
            if (safePreferences.get(hashCode) != null)
                return safePreferences[hashCode] as T
        }

        val newInstance = clazz.constructors.first()
            .newInstance() as T

        preferences?.put(hashCode, newInstance)
        return newInstance
    }
}