package com.hugoapp.adt.presentation.parking.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hugoapp.adt.presentation.parking.home.list.VehicleListFragment

class HomePagerAdapter(
    fragmentManger: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManger, lifecycle) {

    override fun getItemCount(): Int = fragmentsCount

    override fun createFragment(position: Int): Fragment {
        return if (position == INITIAL_PAGE) {
            VehicleListFragment.newInstance()
        } else {
            VehicleListFragment.newInstance()
        }
    }

    companion object {
        const val fragmentsCount = 2
        const val INITIAL_PAGE = 0
    }
}