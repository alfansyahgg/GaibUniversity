package com.example.gaibuniversity.dataModel

import android.icu.number.NumberRangeFormatter.with
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GenericTransitionOptions.with
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.example.gaibuniversity.Module.GlideModule
import com.example.gaibuniversity.R

data class HomeMenuModel(val id_menu: Int?,val nama_menu: String?,val ket_menu: String?,val icon_menu: String?) {

    companion object{
        val baseUrl: String = "http://192.168.42.150/slim-kampus/"
        val iconUrl: String = baseUrl + "icon/"
        @JvmStatic
        @BindingAdapter("icon_menu")
        fun loadImage(view: ImageView, url: String?) {
            if (!url.isNullOrEmpty()) {
                Glide.with(view.context)
                    .load(iconUrl+url)
                    .fitCenter()
                    .placeholder(R.drawable.document)
                    .into(view)
            }
        }
    }


}