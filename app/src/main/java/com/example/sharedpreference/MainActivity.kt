package com.example.sharedpreference

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tituloResource=resources.getString(R.string.title_next)
        val numero=resources.getInteger(R.integer.numeroEntero)
        Log.d("Datos", "${tituloResource}, ${numero}")

        val switchbool1= findViewById<Switch>(R.id.switch2)
        val switchbool2= findViewById<Switch>(R.id.switch3)
        val switchbool3= findViewById<Switch>(R.id.switch4)
        val switchbool4= findViewById<Switch>(R.id.switch5)

        switchbool1.isChecked=resources.getBoolean(R.bool.bool1)
        switchbool2.isChecked=resources.getBoolean(R.bool.bool2)
        switchbool3.isChecked=resources.getBoolean(R.bool.bool3)
        switchbool4.isChecked=resources.getBoolean(R.bool.bool4)

        val titulo=findViewById<TextView>(R.id.titulo)
        titulo.setText(tituloResource)


        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        Log.d("viejo valor", "${resources.getInteger(R.integer.numeroEntero)}")
        if(sharedPref != null){
        val succes=    sharedPref.edit().putInt(getString(R.integer.numeroEntero), 60).commit()
            if(succes){
                val newHighScore = sharedPref.getInt(getString(R.integer.numeroEntero), 5)
                Log.d("nuevo valor", "${newHighScore}")
            }
            Log.d("viejo titulo", "${tituloResource}")
            sharedPref.edit().putString(getString(R.string.title_next), "Nuevo titulo de la app").commit()
            Log.d("nuevo titulo", "${sharedPref.getString(getString(R.string.title_next),"")}")
            //val nuevoTitulo= sharedPref.getString(getString(R.string.title_next),"")

            sharedPref.edit().putString("texto a guardar", "texto que se metera").commit()
            Log.d("experimetno de guardar: ","${sharedPref.getString("texto a guardar","")}")
        }
    //    val sharedPrefeNew= getPreferences(Context.MODE_PRIVATE) ?: return
        //    with (sharedPrefeNew.edit()){
              //  putInt(getString(R.integer.numeroEntero), 11)
                //apply()
       // }

    }
}