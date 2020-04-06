package com.hugoapp.adt.presentation.base

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.hugoapp.adt.presentation.util.Event

abstract class BaseActivity : AppCompatActivity() {

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    abstract val viewModel: BaseViewModel?

    fun <Binding : ViewDataBinding> getBindedView(@LayoutRes layoutId: Int, viewModelId: Int): Binding {
        val binding = DataBindingUtil.setContentView<Binding>(this, layoutId)
        binding.apply {
            lifecycleOwner = this@BaseActivity
            viewModel?.let { setVariable(viewModelId, viewModel) }
        }
        return binding
    }

    fun addOrReplaceFragment(
        @IdRes container: Int,
        fragmentInstance: Fragment,
        addToBackStack: Boolean = true,
        replace: Boolean = false,
        fragmentTag: String = ""
    ) {
        supportFragmentManager.beginTransaction().apply {
            if (replace) {
                replace(container, fragmentInstance, fragmentTag)
            } else {
                add(container, fragmentInstance, fragmentTag)
            }

            if (addToBackStack) {
                addToBackStack(STACK_NAME)
            }
            commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        const val STACK_NAME = "ACTIVITY_FRAGMENT_STACK"
    }
}