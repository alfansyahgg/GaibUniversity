package com.example.gaibuniversity.fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.gaibuniversity.Adapter.HomeAdapter
import com.example.gaibuniversity.Interface.Menus.MenusObject
import com.example.gaibuniversity.dataModel.HomeMenuModel
import com.example.gaibuniversity.ViewModels.HomeViewModel
import com.example.gaibuniversity.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var homebinding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homebinding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        val view = homebinding.root

        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java).apply {
            homebinding.srlDashboard.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
                refreshData()
            })
        }
        setupRecycler()

        modelData()

        return view
    }

    companion object {
        fun newInstance(): HomeFragment{
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    fun modelData(){
        viewModel.getAllHomeMenus(homebinding).observe(viewLifecycleOwner, Observer {
            showData(it.data)
        })
    }

    fun setupRecycler(){
        homeAdapter = HomeAdapter(arrayListOf(),activity?.applicationContext)
        val rv_main = homebinding.rvMain
        val layoutManager = GridLayoutManager(activity, 2)
        with(rv_main){
            setLayoutManager(layoutManager)
            adapter = homeAdapter
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
        }
        homeAdapter.notifyDataSetChanged()
    }



    fun refreshData(){
        homebinding.lavLoading.visibility = View.VISIBLE
        homebinding.rvMain.visibility = View.INVISIBLE
        Handler().postDelayed(Runnable {
            modelData()
        }, 1500)
    }

    fun showData(data: ArrayList<HomeMenuModel.MenusInfo>){
        homeAdapter.setData(data)
    }

}