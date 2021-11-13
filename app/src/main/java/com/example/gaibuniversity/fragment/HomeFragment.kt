package com.example.gaibuniversity.fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.gaibuniversity.Adapter.HomeAdapter
import com.example.gaibuniversity.Interface.Menus.MenusObject
import com.example.gaibuniversity.Model.HomeMenuModel
import com.example.gaibuniversity.R
import com.example.gaibuniversity.databinding.ActivityHomeBinding
import com.example.gaibuniversity.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    lateinit var homebinding: FragmentHomeBinding
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homebinding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        val view = homebinding.root

        getMenusData()
        setupRecycler()
        refreshData()

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

    fun getMenusData(){
        val TAG: String = "GetMenusData"
        MenusObject.menusInterface.getMenus()
            .enqueue(object: Callback<ArrayList<HomeMenuModel>> {
                override fun onResponse(
                    call: Call<ArrayList<HomeMenuModel>>,
                    response: Response<ArrayList<HomeMenuModel>>
                ) {
                    if (response.isSuccessful){
                        val result = response.body()
                        Log.d(TAG, "onResponse: "+result)
                        if (result != null) {
                            homebinding.rvMain.visibility = View.VISIBLE
                            showData(result)
                        }
                    }
                    homebinding.srlDashboard.isRefreshing = false
                }

                override fun onFailure(call: Call<ArrayList<HomeMenuModel>>, t: Throwable) {
                    Log.d(TAG, "onFailure: "+t.stackTrace.toString())
                    homebinding.srlDashboard.isRefreshing = false
                }
            })
    }

    fun refreshData(){
        homebinding.srlDashboard.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            homebinding.rvMain.visibility = View.INVISIBLE
            Handler().postDelayed(Runnable {
                getMenusData()
            }, 1000)
        })
    }

    fun showData(data: ArrayList<HomeMenuModel>){
        homeAdapter.setData(data)
    }

}