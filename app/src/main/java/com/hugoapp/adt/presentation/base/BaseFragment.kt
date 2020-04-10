package com.hugoapp.adt.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

/**
 * BaseFragment abstract class.
 * All presentation fragments should extend this class in order to inherit
 * basic functionality and architecture format.
 *
 * @param layoutId Generated Int ID that represents a layout xml in Resources.
 * @param viewModelId Generated Int ID that represents the errorViewModel variable
 * in the generated binding classes. Use always BR.errorViewModel.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes private val layoutId: Int,
    private val viewModelId: Int
) : Fragment() {

    lateinit var binding: T

    /*
     * ViewModel abstract val.
     * Must be overridden in the child classes.
     * Use Koin's errorViewModel() extension to inject.
     * e.g.
     * override val errorViewModel: DemoViewModel by errorViewModel()
     *
     * Set to null if no ViewModel is needed.
     * e.g.
     * override val errorViewModel: ViewModel? = null
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    abstract val viewModel: BaseViewModel?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            layoutId,
            container,
            false
        ) as T

        return binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel?.let { setVariable(viewModelId, it) }
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Observe snackBarError:
        viewModel?.snackBarError?.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { res ->
                context?.let { showSnackBar(it.getString(res)) }
            }
        })
    }

    private fun showSnackBar(snackBarText: String) {
        activity?.let {
            Snackbar.make(
                it.findViewById<View>(android.R.id.content),
                snackBarText, Snackbar.LENGTH_LONG
            ).show()
        }
    }

    fun loadFragment(fragment: Fragment, containerId: Int, addToBackStack: Boolean = false) {
        childFragmentManager.beginTransaction().apply {
            if (addToBackStack) {
                add(
                    containerId,
                    fragment
                )
                addToBackStack(BASE_STACK)
            } else {
                replace(
                    containerId,
                    fragment
                )
            }
            commit()
        }
    }

    companion object {
        const val BASE_STACK = "STACK"
    }
}