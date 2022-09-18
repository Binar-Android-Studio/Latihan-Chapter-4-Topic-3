package com.example.topic4chapt3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topic4chapt3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var vmProduct : ViewModelProduct
    lateinit var adapterProduct: ProductAdapter
    lateinit var  rvproduct : RecyclerView
    lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//      Panggil View Model
        vmProduct= ViewModelProvider(this).get(ViewModelProduct::class.java)
        adapterProduct = ProductAdapter(ArrayList())

//      Observe live data
        vmProduct.getProduct()
        vmProduct.product.observe(this, Observer {
            adapterProduct.setDataProduct(it as ArrayList<DataProduct> /* = java.util.ArrayList<com.example.topic4chapt3.DataProduct> */)
        })

        binding.rvView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvView.adapter = adapterProduct


    }
}