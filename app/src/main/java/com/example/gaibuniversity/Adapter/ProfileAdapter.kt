package com.example.gaibuniversity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gaibuniversity.dataModel.ProfileMenuModel
import com.example.gaibuniversity.R
import com.example.gaibuniversity.databinding.ItemProfileBinding

class ProfileAdapter(private val profileList: ArrayList<ProfileMenuModel>,context: Context)
    :RecyclerView.Adapter<ProfileAdapter.MyViewHolder>()
{
        class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
            val binding = ItemProfileBinding.bind(view)
            val tv_profile_menu = binding.tvProfileMenu
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_profile,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_profile_menu.text = profileList.get(position).nama
    }

    override fun getItemCount(): Int {
        return profileList.size
    }
}