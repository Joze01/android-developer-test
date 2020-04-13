package com.hugoapp.adt.presentation.parking.home

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.FragmentHomeBinding
import com.hugoapp.adt.presentation.base.BaseFragment
import com.hugoapp.adt.presentation.parking.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home, BR.homeViewModel) {
    override val viewModel: HomeViewModel by viewModel()
    val sharedViewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vp2Vehicles.adapter =
            HomePagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tblTabLayout, binding.vp2Vehicles) { tab, position ->
            if (position == 0) {
                tab.text = getString(R.string.home_vehicle_log_tab)
            } else {
                tab.text = getString(R.string.home_vehicle_tab)
            }
        }.attach()
    }

    override fun onResume() {
        super.onResume()
        sharedViewModel.backButtonVisible.set(false)
        sharedViewModel.appBarTitleObservableField.set(getString(R.string.home_appbar_tittle))
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}