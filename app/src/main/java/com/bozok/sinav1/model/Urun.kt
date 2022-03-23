package com.bozok.sinav1.model

import java.io.Serializable

open class Urun(var marka:String, var ad:String, var fiyat:Double, var tur:Tur, var gorsel:Int,var aciklama:String):Serializable {
}