package com.hugoapp.data.util

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hugoapp.core.util.Resource
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext


abstract class NetworkBoundResource<ResultType> {

    private val result = MutableLiveData<Resource<ResultType>>()
    private val supervisorJob = SupervisorJob()

    suspend fun build(): NetworkBoundResource<ResultType> {
        withContext(Dispatchers.Main) {
            result.value = Resource.loading(null)
        }

        CoroutineScope(coroutineContext).launch(supervisorJob) {
            val dbResult = loadFromDb()
            setValue(Resource.success(dbResult))
        }
        return this
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>


    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) result.postValue(newValue)
    }

    @MainThread
    protected abstract suspend fun loadFromDb(): ResultType
}