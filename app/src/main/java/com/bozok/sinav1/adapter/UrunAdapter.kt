package com.bozok.sinav1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bozok.sinav1.R
import com.bozok.sinav1.model.Urun

class UrunAdapter(var context: Context, var urunList: ArrayList<Urun>,var urunAddClick:(position:Int)->Unit,var urunClick:(position:Int)->Unit):RecyclerView.Adapter<UrunViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrunViewHolder {
        val v= LayoutInflater.from(context).inflate(R.layout.rv_urun,parent,false)
        return UrunViewHolder(v,urunAddClick,urunClick)
    }

    override fun onBindViewHolder(holder: UrunViewHolder, position: Int) {
        holder.bindData(urunList.get(position))

    }

    override fun getItemCount(): Int {
        return urunList.size
    }
}