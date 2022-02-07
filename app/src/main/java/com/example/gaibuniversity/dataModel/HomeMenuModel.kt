package com.example.gaibuniversity.dataModel

import android.icu.number.NumberRangeFormatter.with
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GenericTransitionOptions.with
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.example.gaibuniversity.Module.GlideModule
import com.example.gaibuniversity.R

data class HomeMenuModel(val success: Boolean, val message: String, val data: ArrayList<MenusInfo>) {
    data class MenusInfo(val id_menu: Int?,val nama_menu: String?,val ket_menu: String?,val icon_menu: String?){

    }
}