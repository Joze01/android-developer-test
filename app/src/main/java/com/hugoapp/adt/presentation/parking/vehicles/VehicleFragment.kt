package com.hugoapp.adt.presentation.parking.vehicles

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.FragmentVehicleBinding
import com.hugoapp.adt.presentation.base.BaseFragment
import com.hugoapp.adt.presentation.parking.MainViewModel
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class VehicleFragment :
    BaseFragment<FragmentVehicleBinding>(R.layout.fragment_vehicle, BR.vehicleViewModel) {
    override val viewModel: VehicleViewModel by viewModel()
    val sharedViewModel: MainViewModel by sharedViewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.backButtonVisible.set(true)
        sharedViewModel.appBarTitleObservableField.set(getString(R.string.vehicle_title))
        viewModel.fragmentNavigationObservable.observe(viewLifecycleOwner, navigationObserver())
    }

    fun navigationObserver() = Observer<Event<FragmentNavigationEvents>> { event ->
        event.getContentIfNotHandled()?.let {
            when (it) {
                FragmentNavigationEvents.BACK ->
                    sharedViewModel.fragmentNavigationObservable.value = Event(it)
            }
        }
    }


    companion object {
        fun newInstance() = VehicleFragment()

        const val TAG = "NEW_VEHICLE_FRAGMENT"
    }
}