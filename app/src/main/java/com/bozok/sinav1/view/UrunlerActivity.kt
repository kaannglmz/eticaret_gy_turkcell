package com.bozok.sinav1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bozok.sinav1.R
import com.bozok.sinav1.adapter.TurAdapter
import com.bozok.sinav1.adapter.UrunAdapter
import com.bozok.sinav1.adapter.UrunViewHolder
import com.bozok.sinav1.databinding.ActivityUrunlerBinding
import com.bozok.sinav1.model.Tur
import com.bozok.sinav1.model.Urun
import com.bozok.sinav1.util.Constants.giris
import com.bozok.sinav1.util.Constants.toplamFiyat


class UrunlerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUrunlerBinding
    lateinit var turListe:ArrayList<Tur>
    lateinit var urunListe:ArrayList<Urun>
    lateinit var urunSuListe:ArrayList<Urun>
    lateinit var urunMeyveSuyuListe:ArrayList<Urun>
    lateinit var urunGazliIcecekListe:ArrayList<Urun>
    lateinit var urunMadenSuyuListe:ArrayList<Urun>
    lateinit var urunAyranKefirListe:ArrayList<Urun>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUrunlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        urunTurListeTanimla()

        val lm= LinearLayoutManager(this)
        lm.orientation= LinearLayoutManager.HORIZONTAL
        binding.rvTurList.layoutManager=lm
        binding.rvTurList.adapter=TurAdapter(this,turListe,::turClick)

        // Her satırda 4 tane ürün olacak şekilde ayarlıyoruz.
        val lm2= GridLayoutManager(applicationContext,4,GridLayoutManager.VERTICAL,false)
        binding.rvUrunList.layoutManager=lm2
        binding.rvUrunList.adapter= UrunAdapter(this,urunListe,::urunAddClick, ::urunClick)

        binding.imgbtnBack.setOnClickListener { finish() }

        if(giris == "üyeliksiz"){
            binding.imgbtnShoppingCart.visibility= View.GONE
            binding.tvSepetFiyat.visibility=View.GONE
        }


    }

    override fun onResume() {
        super.onResume()
        binding.tvSepetFiyat.text= "₺$toplamFiyat"
    }

    fun urunAddClick(position:Int){

       var fiyat=urunListe.get(position).fiyat
        toplamFiyat+=fiyat
        binding.tvSepetFiyat.text= "₺$toplamFiyat"
    }
    fun urunClick(position:Int){
        var fiyat=binding.tvSepetFiyat.text.toString()
        if(giris=="üyegirisi"){
            val intent=Intent(this,UrunDetayActivity::class.java)
           // intent.putExtra("info",fiyat)
            intent.putExtra("ürün",urunListe.get(position))
            startActivity(intent)

        }else{
            val intent=Intent(this,UrunDetayActivity::class.java)
            intent.putExtra("ürün",urunListe.get(position))
            intent.putExtra("üyesizgiriş","üyesizgiriş")
            startActivity(intent)
        }

    }

    fun turClick(position:Int){
        urunListe.clear()
        when(position){
            0 -> {urunListe.addAll(urunSuListe)}
            1 -> {urunListe.addAll(urunMeyveSuyuListe)}
            2 -> {urunListe.addAll(urunGazliIcecekListe)}
            3 -> {urunListe.addAll(urunMadenSuyuListe)}
            4 -> {urunListe.addAll(urunAyranKefirListe)}
        }
            binding.rvUrunList.adapter!!.notifyDataSetChanged()

    }

    fun urunTurListeTanimla(){
        var su=Tur("Su")
        var meyvesuyu=Tur("Meyve Suyu")
        var gazliicecek=Tur("Gazlı İçecek")
        var madensuyu=Tur("Maden Suyu")
        var ayrankefir=Tur("Ayran & Kefir ")
        turListe= arrayListOf<Tur>(su,meyvesuyu,gazliicecek,madensuyu,ayrankefir)

        var sirmaSu=Urun("Sırma","Su",3.75,su, R.drawable.sirmasu,"İçme Suyu")
        var pinarSu=Urun("Pınar","Su",3.85,su, R.drawable.pinarsu,"İçme Suyu")
        var hayatSu=Urun("Hayat","Su",3.75,su, R.drawable.hayatsu,"İçme Suyu")
        urunListe=arrayListOf(sirmaSu,pinarSu,hayatSu)
        urunSuListe= arrayListOf(sirmaSu,pinarSu,hayatSu)

        var meysu=Urun("Meysu","Meyve Suyu",4.55,meyvesuyu,R.drawable.meysu,"Karışık Meyve Aromalı")
        var dimes=Urun("Dimes","Meyve Suyu",4.95,meyvesuyu,R.drawable.dimes,"Orman Meyveli")
        var cappy=Urun("Cappy","Meyve Suyu",4.15,meyvesuyu,R.drawable.cappy,"Elmalı Meyve suyu")
        urunMeyveSuyuListe= arrayListOf(meysu,dimes,cappy)

        var pepsi=Urun("Pepsi","Kola",4.55,gazliicecek,R.drawable.pepsi,"Gazlı Şekerli İçecek")
        var uludağ=Urun("Uludağ","Gazoz",4.95,gazliicecek,R.drawable.uludaggazoz,"Şekerli Uludağ Gazozu")
        var fanta=Urun("Fanta","Portakallı İçecek",4.15,gazliicecek,R.drawable.fanta,"Portakal Aromalı Gazlı İçecek")
        urunGazliIcecekListe= arrayListOf(pepsi,uludağ,fanta)

        var beypazari=Urun("Beypazarı","Maden Suyu",4.55,madensuyu,R.drawable.beypazari,"Doğal Maden Suyu")
        var kizilay=Urun("Dimes","Maden Suyu",4.95,madensuyu,R.drawable.kizilay,"Sade Maden Suyu")
        var sirma=Urun("Sırma","Maden Suyu",4.15,madensuyu,R.drawable.sirmamadensuyu,"Sadece Maden Suyu")
        urunMadenSuyuListe= arrayListOf(beypazari,kizilay,sirma)

        var sutas=Urun("Sütaş","Ayran",4.55,ayrankefir,R.drawable.sutas,"Yarım Yağlı Sütten Yapılmıştır")
        var eker=Urun("Eker","Kefir",4.95,ayrankefir,R.drawable.ekerkefir,"Bol Vitaminli Kefir")
        var pinar=Urun("Pınar","Ayran",4.15,ayrankefir,R.drawable.pinarayran,"Tam Yağlı Sütten Yapılmıştır")
        var icim=Urun("İçim","Kefir",4.15,ayrankefir,R.drawable.icimkefir,"Meyveli Kefir")
        var torku=Urun("Torku","Ayran",4.15,ayrankefir,R.drawable.torkuayran,"Nefis Ayran")
        urunAyranKefirListe= arrayListOf(sutas,eker,pinar,icim,torku)
    }

}
