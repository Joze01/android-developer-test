package com.hugoapp.adt.presentation.parking

import android.os.Bundle
import androidx.lifecycle.Observer
import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.ActivityMainBinding
import com.hugoapp.adt.presentation.base.BaseActivity
import com.hugoapp.adt.presentation.parking.home.HomeFragment
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModel()

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getBindedView(R.layout.activity_main, BR.mainViewModel)
        viewModel.apply {
            backButtonVisible.set(false)
            appBarTitleObservableField.set(getString(R.string.home_appbar_tittle))
            fragmentNavigationObservable.observe(this@MainActivity, fragmentNavigationObserver())
        }
    }

    fun fragmentNavigationObserver() = Observer<Event<FragmentNavigationEvents>> { event ->
        event.getContentIfNotHandled()?.let {
            when (it) {
                FragmentNavigationEvents.BACK -> onBackPressed()
                FragmentNavigationEvents.HOME_FRAGMENT -> addOrReplaceFragment(
                    R.id.cl_container,
                    HomeFragment.newInstance(),
                    addToBackStack = false,
                    replace = true,
                    fragmentTag = HomeFragment.TAG
                )
            }
        }

    }
}
