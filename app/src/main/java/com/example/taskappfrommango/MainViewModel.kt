package com.example.taskappfrommango

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskappfrommango.common.api.Resource
import com.example.taskappfrommango.common.model.CareerList
import com.example.taskappfrommango.common.model.CountryList
import com.example.taskappfrommango.common.model.RequestBody
import com.example.taskappfrommango.common.repository.MangoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MangoRepository) : ViewModel() {

    private val _countryList = MutableLiveData<List<CountryList>>()

    private val _careerList = MutableLiveData<List<CareerList>>()

    val countryList
        get() = _countryList

    val careerList
        get() = _careerList

    fun getCountryList(map: RequestBody) {
        viewModelScope.launch {
            repo.getListOfCountries(map).collectLatest {
                when (it.status) {
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        if (it.data != null) {
                            _countryList.value = it.data!!
                        }
                    }
                    Resource.Status.ERROR -> {

                    }
                }
            }
        }
    }

    fun getCareerList(map: RequestBody) {
        viewModelScope.launch {
            repo.getListOfCareer(map).collectLatest {
                when (it.status) {
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        if (it.data != null) {
                            _careerList.value = it.data!!
                        }
                    }
                    Resource.Status.ERROR -> {

                    }
                }
            }
        }
    }

}