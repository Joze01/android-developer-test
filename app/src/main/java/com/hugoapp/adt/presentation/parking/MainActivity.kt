package com.hugoapp.adt.presentation.parking

import android.os.Bundle
import com.hugoapp.adt.BR
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.ActivityMainBinding
import com.hugoapp.adt.presentation.base.BaseActivity
import com.hugoapp.adt.presentation.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModel()

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getBindedView(R.layout.activity_main, BR.mainViewModel)
    }
}
