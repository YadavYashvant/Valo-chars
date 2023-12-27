package com.example.quickity.api_feature.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickity.api_feature.Network.RetrofitInstance
import com.example.quickity.api_feature.apidata.Agents
import com.example.quickity.api_feature.apidata.DataItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _agentsData : MutableStateFlow<List<DataItem>> = MutableStateFlow(listOf())
    val agentsData : StateFlow<List<DataItem>> = _agentsData

    private fun retrieveAgentsData(){
        viewModelScope.launch {
            val call : Call<Agents> = RetrofitInstance.apiService.getAllAgents()
            call.enqueue(object : Callback<Agents> {
                override fun onResponse(
                    call: Call<Agents>,
                    response: Response<Agents>
                ) {
                    if(response.isSuccessful){
                        val responseData: List<DataItem?>? = response.body()?.data
                        if(responseData != null){
                            _agentsData.value = responseData.filter { dataItem ->  dataItem.role?.displayName != null }!!
                        }
                    }
                }
                override fun onFailure(call: Call<Agents>, t: Throwable) {
                    Log.d("Failed Retrieve", "Network Error")
                }
            })
        }
    }
}