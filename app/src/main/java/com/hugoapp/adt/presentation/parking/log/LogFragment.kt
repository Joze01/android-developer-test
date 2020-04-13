package com.hugoapp.adt.presentation.parking.log

import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.FragmentLogListBinding
import com.hugoapp.adt.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class LogFragment :
    BaseFragment<FragmentLogListBinding>(R.layout.fragment_log_list, BR.logListViewModel) {
    override val viewModel: LogViewModel by viewModel()

    companion object {
        fun newInstance() = LogFragment()

        const val TAG = "LOG_FRAGMENT"
    }
}