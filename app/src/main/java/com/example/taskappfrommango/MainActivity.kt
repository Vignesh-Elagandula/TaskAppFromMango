package com.example.taskappfrommango

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.example.taskappfrommango.common.constants.Constants
import com.example.taskappfrommango.common.model.CareerList
import com.example.taskappfrommango.common.model.CountryList
import com.example.taskappfrommango.common.model.RequestBody
import com.example.taskappfrommango.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding : ActivityMainBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val list: MutableList<String> = ArrayList()

            val newList: MutableList<CareerList> = ArrayList()

            val request = RequestBody(tokenKey = Constants.TOKEN_KEY)

            viewModel.getCountryList(request)
            viewModel.countryList.observe(this@MainActivity) {
                if (it.isNotEmpty()) {
                    for (i in it.indices) {
                        list.add(it[i].name)
                    }
                    spinner.adapter = ArrayAdapter(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        list
                    )
                }
            }
            viewModel.getCareerList(request)
            viewModel.careerList.observe(this@MainActivity) {
                if (it.isNotEmpty()) {
                    for (i in it.indices) {
                        newList.add(it[i])
                    }
                    careerListRecyclerView.adapter = ArrayAdapter(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        newList
                    )
                }
            }
        }

    }
}