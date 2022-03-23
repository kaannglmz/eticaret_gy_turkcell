package com.bozok.sinav1.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bozok.sinav1.R
import com.bozok.sinav1.model.Urun
import com.bozok.sinav1.util.Constants.giris


class UrunViewHolder(itemView: View,var urunAddClick:(position:Int)->Unit, urunClick: (position: Int) -> Unit) :RecyclerView.ViewHolder(itemView) {
    var ivUrunGorsel: ImageView
    var tvUrunlerMarka:TextView
    var tvUrunlerUrunAdi:TextView
    var tvUrunlerFiyat:TextView
    var imgAddShopCart:ImageButton


    init {
        ivUrunGorsel=itemView.findViewById(R.id.ivUrunGorsel)
        tvUrunlerMarka=itemView.findViewById(R.id.tvUrunlerMarka)
        tvUrunlerUrunAdi=itemView.findViewById(R.id.tvUrunlerUrunAdi)
        tvUrunlerFiyat=itemView.findViewById(R.id.tvUrunlerUrunFiyat)
        imgAddShopCart=itemView.findViewById(R.id.imgAddShoppCart)
        if(giris=="üyeliksiz") imgAddShopCart.visibility=View.GONE
        //tıklama işlemleri için
        itemView.setOnClickListener {
            urunClick(adapterPosition)
        }
        imgAddShopCart.setOnClickListener {
            urunAddClick(adapterPosition)
        }
    }

    fun bindData(urun:Urun){
        ivUrunGorsel.setImageResource(urun.gorsel)
        tvUrunlerMarka.text=urun.marka
        tvUrunlerUrunAdi.text=urun.ad
        tvUrunlerFiyat.text="₺"+urun.fiyat.toString()


    }
}