package com.bozok.sinav1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.bozok.sinav1.R
import com.bozok.sinav1.databinding.ActivityMainBinding
import com.bozok.sinav1.util.Constants.giris
import com.bozok.sinav1.util.Constants.sifre
import com.bozok.sinav1.util.Constants.telNo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var sifreDurum:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnGiris.setOnClickListener { girisKontrol() }
        binding.btnGiris2.setOnClickListener { uyeliksizGiris() }
        binding.imgBtnVisible.setOnClickListener { sifreGoster() }


    }
    fun girisKontrol(){
        val girilenTelNo=binding.etTelefon.text.toString()
        val girilenSifre=binding.etSifre.text.toString()

        if(girilenTelNo==telNo && girilenSifre==sifre){
            val intent=Intent(this,UrunlerActivity::class.java)
            //intent.putExtra("üyegirişi","üye")
            giris="üye"
            resultLauncher.launch(intent)

        }else{
            val adb=AlertDialog.Builder(this)
            adb.setTitle("Hata!")
            adb.setMessage("Telefon numarası veya şifre hatalı!")
            adb.setNeutralButton("Tamam",null)
            adb.show()
        }
    }

    fun uyeliksizGiris(){
        val intent=Intent(this,UrunlerActivity::class.java)
        //intent.putExtra("üyeliksizgiriş","üyesiz")
        giris="üyeliksiz"
        resultLauncher.launch(intent)
    }

    fun sifreGoster(){

        if(sifreDurum){
            binding.imgBtnVisible.setImageResource(R.drawable.invisible)
            binding.etSifre.transformationMethod=HideReturnsTransformationMethod()
            binding.etSifre.setSelection(binding.etSifre.getText().length)
            sifreDurum=false
        }else {
            binding.imgBtnVisible.setImageResource(R.drawable.visible)
            binding.etSifre.transformationMethod = PasswordTransformationMethod()
            binding.etSifre.setSelection(binding.etSifre.getText().length)
            sifreDurum=true
        }

    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

            result ->
        if(result.resultCode== RESULT_OK){

        }
    }
}

/* <ImageButton
        android:id="@+id/imgBtnInVisible"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="20dp"
        android:background="#FFFFFF"
        android:minWidth="48dp"
        android:minHeight="48dp"
        android:src="@drawable/invisible"
        app:layout_constraintBottom_toBottomOf="@+id/etSifre"
        app:layout_constraintEnd_toEndOf="@+id/etSifre"
        app:layout_constraintTop_toTopOf="@+id/etSifre" />

    <ImageButton
        android:id="@+id/imgBtnVisible"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="20dp"
        android:background="#FFFFFF"
        android:minWidth="48dp"
        android:minHeight="48dp"
        android:src="@drawable/visible"
        app:layout_constraintBottom_toBottomOf="@+id/etSifre"
        app:layout_constraintEnd_toEndOf="@+id/etSifre"
        app:layout_constraintTop_toTopOf="@+id/etSifre" />
*/