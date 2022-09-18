package com.example.topic4chapt3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    var list = arrayListOf(
        DataProduct("Samsung", R.drawable.tutorial_3,"$25",34,"sepeda", 15),
        DataProduct("mito", R.drawable.tutorial_3,"$35",12,"motor", 12),
        DataProduct("xiomi", R.drawable.tutorial_3,"$24",34,"sepeda", 13),
        DataProduct("maomi", R.drawable.tutorial_3,"$65",34,"sepeda", 16),
        DataProduct("hade", R.drawable.tutorial_3,"$78",34,"sepeda", 17)
    )

//    bikin live data
    val product : MutableLiveData<List<DataProduct>> = MutableLiveData()

//    set data ke live data
    fun getProduct (){
        product.value = list
    }
}