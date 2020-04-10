package com.hugoapp.adt.presentation.parking.home

import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.FragmentHomeBinding
import com.hugoapp.adt.presentation.base.BaseFragment
import com.hugoapp.adt.presentation.base.BaseViewModel
import com.hugoapp.adt.presentation.parking.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home, BR.homeViewModel
) {
    override val viewModel: BaseViewModel by viewModel()
    val sharedViewModel: MainViewModel by sharedViewModel()

    companion object {
        fun newInstance() = HomeFragment()

        const val TAG = "HOME_FRAGMENT"
    }
}