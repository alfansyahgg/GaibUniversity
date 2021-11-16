package com.example.gaibuniversity.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.gaibuniversity.Adapter.ProfileAdapter
import com.example.gaibuniversity.dataModel.ProfileMenuModel
import com.example.gaibuniversity.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    lateinit var profileBinding: FragmentProfileBinding

    val profileList = ArrayList<ProfileMenuModel>()
    lateinit var profileAdapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileBinding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        val view = profileBinding.root

        profileList.add(ProfileMenuModel("Kartu Mahasiswa Elektronik"))
        profileList.add(ProfileMenuModel("Change Profile"))
        profileList.add(ProfileMenuModel("Security"))
        profileList.add(ProfileMenuModel("Privacy"))
        profileList.add(ProfileMenuModel("About App"))

        profileAdapter  = ProfileAdapter(profileList, activity?.applicationContext!!)
        val layoutManager = LinearLayoutManager(activity)
        with(profileBinding.rvProfile){
            setLayoutManager(layoutManager)
            adapter = profileAdapter
            setHasFixedSize(true)
        }
        profileAdapter.notifyDataSetChanged()


        profileBinding.srlMain.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            Handler().postDelayed(Runnable {
                Toast.makeText(activity?.applicationContext!!, "Refreshed", Toast.LENGTH_SHORT).show()
                profileBinding.srlMain.isRefreshing = false
            },1000)
        })

        return view
    }

    companion object {

        fun newInstance(): ProfileFragment{
            val fragment = ProfileFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}