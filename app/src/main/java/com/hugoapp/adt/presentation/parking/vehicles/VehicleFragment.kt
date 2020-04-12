package com.hugoapp.adt.presentation.parking.vehicles

import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.FragmentVehicleBinding
import com.hugoapp.adt.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class VechicleFragment :
    BaseFragment<FragmentVehicleBinding>(R.layout.fragment_vehicle, BR.vehicleViewModel) {
    override val viewModel: VehicleViewModel by viewModel()
}