package com.bozok.sinav1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bozok.sinav1.R
import com.bozok.sinav1.databinding.ActivityUrunDetayBinding
import com.bozok.sinav1.model.Urun
import com.bozok.sinav1.util.Constants.giris
import com.bozok.sinav1.util.Constants.toplamFiyat

class UrunDetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUrunDetayBinding
    var urun:Urun?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUrunDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var fiyat:Double=0.0


        urun= intent.getSerializableExtra("ürün") as Urun?

        if(giris=="üye") {
            binding.tvSepetFiyat.text = "₺$toplamFiyat"

            binding.tvFiyat.text = urun!!.fiyat.toString()
            binding.tvMarka.text = urun!!.marka
            binding.tvUrunAdi.text = urun!!.ad
            binding.imgUrunGorsel.setImageResource(urun!!.gorsel)
            binding.tvUrunDetay.text = urun!!.aciklama
        }else{
            binding.tvFiyat.text = "₺"+urun!!.fiyat.toString()
            binding.tvMarka.text = urun!!.marka
            binding.tvUrunAdi.text = urun!!.ad
            binding.imgUrunGorsel.setImageResource(urun!!.gorsel)
            binding.tvUrunDetay.text = urun!!.aciklama

            binding.imgbtnShoppingCart.visibility= View.GONE
            binding.tvSepetFiyat.visibility=View.GONE
            binding.imgbtnAdd.visibility=View.GONE
        }

        binding.imgbtnBack.setOnClickListener {
            finish()
        }

        binding.imgbtnAdd.setOnClickListener {
            fiyat=binding.tvFiyat.text.toString().toDouble()
            toplamFiyat+=fiyat
            binding.tvSepetFiyat.text= "₺$toplamFiyat"

        }


    }


}