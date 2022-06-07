package com.sbaldass.cryptotracker.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.sbaldass.cryptotracker.R
import com.sbaldass.cryptotracker.api.ApiInterface
import com.sbaldass.cryptotracker.api.ApiUtils
import com.sbaldass.cryptotracker.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        getTopCurrencyList()

        return binding.root
    }

    private fun getTopCurrencyList() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtils.getInstance().create(ApiInterface::class.java).getMarketData()
            Log.d("SAMUEL", "getTopCurrencyList: ${res.body()!!.data.cryptoCurrencyList}")
        }
    }
}