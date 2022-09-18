package com.example.topic4chapt3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.topic4chapt3.databinding.ActivityDetailProductBinding

class DetailProduct : AppCompatActivity() {
    lateinit var binding : ActivityDetailProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_product)



        var getname = intent.getSerializableExtra("title")
        var getdetail = intent.getSerializableExtra("detail")
        var getprice = intent.getSerializableExtra("price")
        var getimage = intent.getSerializableExtra("image")


        binding.data = DataProduct(
            getname as String,
            getimage as Int,
            getprice as String,
            20,
            getdetail as String,
            30)

        binding.button.setOnClickListener(){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            // Setting whatsapp package name
            intent.setPackage("com.whatsapp")
            var message  : String
            message = "hallo saya tertarik dengan produk" + getname + "dengan harga" + getprice + ", apakah masih ada ?"
            intent.putExtra(Intent.EXTRA_TEXT, message)

            // Checking whether whatsapp is installed or not
            if (intent.resolveActivity(packageManager) == null) {
                Toast.makeText(this,
                    "Please install whatsapp first.",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                startActivity(intent)
            }
        }

    }

}