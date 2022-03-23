package com.bozok.sinav1.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bozok.sinav1.R
import com.bozok.sinav1.model.Tur
import com.bozok.sinav1.model.Urun


class TurAdapter(var context:Context, var turList:ArrayList<Tur>, var turClick:(position:Int)->Unit) : RecyclerView.Adapter<TurViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurViewHolder {
        val v= LayoutInflater.from(context).inflate(R.layout.rv_tur,parent,false)
        return TurViewHolder(v,turClick)
    }

    override fun onBindViewHolder(holder: TurViewHolder, position: Int) {
        holder.bindData(turList.get(position))
    }

    override fun getItemCount(): Int {
        return turList.size
    }
}