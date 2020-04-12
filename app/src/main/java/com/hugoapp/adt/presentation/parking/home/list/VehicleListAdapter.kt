package com.hugoapp.adt.presentation.parking.home.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hugoapp.adt.R
import com.hugoapp.adt.databinding.ItemVehicleListBinding
import com.hugoapp.adt.presentation.util.Event
import com.hugoapp.data.db.model.VehicleModel

class VehicleListAdapter(
    val itemsList: List<VehicleModel>,
    val itemClickEvent: MutableLiveData<Event<VehicleModel>>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_vehicle_list,
                parent,
                false
            )
        )

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemVehicleListBinding? = DataBindingUtil.bind(view)
        fun bindData(
            vehicleModel: VehicleModel,
            clickEvent: MutableLiveData<Event<VehicleModel>>
        ) {
            binding?.itemViewModel = VehicleItemViewModel(vehicleModel, clickEvent)
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bindData(itemsList[position], itemClickEvent)
    }
}