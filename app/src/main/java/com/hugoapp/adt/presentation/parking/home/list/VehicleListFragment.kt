package com.hugoapp.adt.presentation.parking.home.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.FragmentVehicleListBinding
import com.hugoapp.adt.presentation.base.BaseFragment
import com.hugoapp.adt.presentation.parking.MainViewModel
import com.hugoapp.adt.presentation.parking.home.list.VehicleListAdapter
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.adt.presentation.util.FragmentNavigationEvents
import com.hugoapp.data.db.model.VehicleModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VehicleListFragment : BaseFragment<FragmentVehicleListBinding>(
    R.layout.fragment_vehicle_list, BR.vehicleListViewModel
) {
    override val viewModel: VehicleListViewModel by viewModel()
    val sharedViewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvVehicles.layoutManager = LinearLayoutManager(requireContext())
        viewModel.fragmentNavigationObservable.observe(viewLifecycleOwner, navigationObserver())
        viewModel.itemClickEvent.observe(viewLifecycleOwner, selectedItemObserver())
        viewModel.vehicleData.observe(viewLifecycleOwner, vehicleListObserver())
        viewModel.getListData()
    }

    fun selectedItemObserver() = Observer<Event<VehicleModel>> { event ->
        event.getContentIfNotHandled()?.let {
            Log.wtf("JACC", it.plateNumber)
        }
    }

    fun vehicleListObserver() = Observer<Event<List<VehicleModel>>> { event ->
        event.getContentIfNotHandled()?.let {
            binding.rvVehicles.adapter =
                VehicleListAdapter(it, viewModel.itemClickEvent)
        }
    }

    fun navigationObserver() = Observer<Event<FragmentNavigationEvents>> { event ->
        event.getContentIfNotHandled()?.let {
            when (it) {
                FragmentNavigationEvents.NEW_VEHICLE_FRAGMENT ->
                    sharedViewModel.fragmentNavigationObservable.value = Event(it)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sharedViewModel.backButtonVisible.set(false)
        sharedViewModel.appBarTitleObservableField.set(getString(R.string.home_appbar_tittle))
        viewModel.getListData()
    }

    companion object {
        fun newInstance() = VehicleListFragment()

        const val TAG = "HOME_FRAGMENT"
    }
}