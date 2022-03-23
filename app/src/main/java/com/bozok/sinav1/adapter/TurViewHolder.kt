package com.bozok.sinav1.adapter

import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bozok.sinav1.R
import com.bozok.sinav1.model.Tur

class TurViewHolder( itemView: View, var turClick:(position:Int)->Unit) :RecyclerView.ViewHolder(itemView) {

    var tvTur: TextView

    init {
        tvTur=itemView.findViewById(R.id.tvTur)
        //tıklama işlemleri için
        itemView.setOnClickListener {
            turClick(adapterPosition)

        }

    }

    fun bindData(tur:Tur){
        tvTur.text=tur.ad
    }

}