package com.example.topic4chapt3

import android.content.Intent
import android.icu.text.Transliterator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.topic4chapt3.databinding.ItemProductBinding

class ProductAdapter (var list : ArrayList<DataProduct>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    var onClick : ((DataProduct)-> Unit)? = null

    class ViewHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemData : DataProduct){
            binding.product = itemData
            binding.productnya.setOnClickListener(object : View.OnClickListener{
                override fun onClick(view: View?) {
                    var bundle = Bundle()
                    bundle.putString("title", itemData.nameProduct)
                    bundle.putString("detail", itemData.descProduct)
                    bundle.putString("price", itemData.price)
                    bundle.putInt("image", itemData.imgProduct)
                    val intent = Intent(view!!.context,DetailProduct::class.java)
                    intent.putExtras(bundle)
                    view.context.startActivity(intent)
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataProduct(itemData: ArrayList<DataProduct>){
        this.list = itemData
    }


}