package com.hugoapp.data.db.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hugoapp.data.db.model.VehicleModel
import com.hugoapp.data.db.model.VehicleTypeModel

class Converters {

    @TypeConverter
    fun fromVehicle(value: VehicleModel): String? =
        Gson().toJson(value)

    @TypeConverter
    fun toVehicle(value: String): VehicleModel =
        Gson().fromJson(value, VehicleModel::class.java)

    @TypeConverter
    fun fromVehicleType(value: VehicleTypeModel): String? =
        Gson().toJson(value)

    @TypeConverter
    fun toVehicleType(value: String): VehicleTypeModel =
        Gson().fromJson(value, VehicleTypeModel::class.java)
}