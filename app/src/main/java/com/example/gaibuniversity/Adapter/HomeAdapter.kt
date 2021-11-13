package com.example.gaibuniversity.Adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gaibuniversity.Model.HomeMenuModel
import com.example.gaibuniversity.R
import com.example.gaibuniversity.databinding.ItemHomeBinding
import org.w3c.dom.Text

class HomeAdapter(private val HomeList: ArrayList<HomeMenuModel>,private val context: Context?) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>()
{
    val baseUrl: String = "http://192.168.42.150/slim-kampus/"
    val iconUrl: String = baseUrl + "icon/"

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemHomeBinding.bind(view)
        val tv_name = binding.tvName
        val iv_icon = binding.ivIcon
        val cv_menu = binding.cvMenu
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.tv_name.text = HomeList.get(position).nama_menu

        if (context != null) {
            Glide.with(context)
                .load(iconUrl+HomeList.get(position).icon_menu)
                .fitCenter()
                .placeholder(R.drawable.document)
                .into(holder.iv_icon)
        }

        holder.cv_menu.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "${HomeList.get(position).ket_menu}", Toast.LENGTH_SHORT).show()
        })

    }

    override fun getItemCount(): Int {
        return HomeList.size
    }

    fun setData(data: ArrayList<HomeMenuModel>){
        HomeList.clear()
        HomeList.addAll( data )
        notifyDataSetChanged()
    }
}