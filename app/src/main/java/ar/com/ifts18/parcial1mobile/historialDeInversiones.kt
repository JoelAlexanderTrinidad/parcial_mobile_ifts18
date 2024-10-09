package ar.com.ifts18.parcial1mobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.widget.Button

class historialDeInversiones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.historial)

        val tv1=findViewById<TextView>(R.id.TV1_2)
        val tv2=findViewById<TextView>(R.id.TV1_3)
        val tv3=findViewById<TextView>(R.id.TV1_4)
        val tv4=findViewById<TextView>(R.id.TV1_5)
        val tv5=findViewById<TextView>(R.id.TV1_6)
        val tv6=findViewById<TextView>(R.id.TV1_7)
        val tv7=findViewById<TextView>(R.id.TV1_8)
        val tv8=findViewById<TextView>(R.id.TV1_9)
        val tv9=findViewById<TextView>(R.id.TV1_10)
        val tv10=findViewById<TextView>(R.id.TV1_11)
        val tv11=findViewById<TextView>(R.id.TV1_12)
        val tv12=findViewById<TextView>(R.id.TV1_13)
        val tv13=findViewById<TextView>(R.id.TV1_14)
        val tv14=findViewById<TextView>(R.id.TV1_15)
        val tv15=findViewById<TextView>(R.id.TV1_16)
        val tv16=findViewById<TextView>(R.id.TV1_17)
        val tv17=findViewById<TextView>(R.id.TV1_18)
        val tv18=findViewById<TextView>(R.id.TV1_19)
        val tv19=findViewById<TextView>(R.id.TV1_20)
        val tv20=findViewById<TextView>(R.id.TV1_21)
        val tv21=findViewById<TextView>(R.id.TV1_22)
        val tv22=findViewById<TextView>(R.id.TV1_23)
        val tv23=findViewById<TextView>(R.id.TV1_24)
        val tv24=findViewById<TextView>(R.id.TV1_25)
        val tv25=findViewById<TextView>(R.id.TV1_26)
        val tv26=findViewById<TextView>(R.id.TV1_27)
        val tv27=findViewById<TextView>(R.id.TV1_28)
        val tv28=findViewById<TextView>(R.id.TV1_29)
        val tv29=findViewById<TextView>(R.id.TV1_30)
        val bot=findViewById<Button>(R.id.atras)



        val preferencias = getSharedPreferences("loginPref", Context.MODE_PRIVATE)
        val banco = preferencias.getString("banco","")
        val banco2 = preferencias.getString("banco 2","")
        val montoTotal = preferencias.getString("montoTotal","0.0")?.toDouble() ?: 0.0
        val montoTotal2 = preferencias.getString("montoTotal 2","0.0")?.toDouble() ?: 0.0
        val interesesGenerados = preferencias.getString("interesesGenerados","0.0")?.toDouble() ?: 0.0
        val interesesGenerados2 = preferencias.getString("interesesGenerados 2","0.0")?.toDouble() ?: 0.0


        /*val editor = preferencias.edit()


        val historialInversiones = preferencias.getStringSet("historialInversiones", mutableSetOf())


        val nuevaInversion = "Banco: $banco, Banco 2: $banco2, " +
                "Intereses Generados: $interesesGenerados, Intereses Generados 2: $interesesGenerados2, " +
                "Monto Total: $montoTotal, Monto Total 2: $montoTotal2"


        val nuevoHistorial = historialInversiones?.toMutableSet() ?: mutableSetOf()
        nuevoHistorial.add(nuevaInversion)


        editor.putStringSet("historialInversiones", nuevoHistorial)
        editor.apply()*/


        tv1.text = "banco: Santander"
        tv2.text = "intereses Generados: $41.67"
        tv3.text = "total: $1041.67"
        tv4.text = "banco2: BBVA"
        tv5.text = "intereses Generados2: $33.33"
        tv6.text = "total2: $1033.33"

        tv7.text = "banco: Santander"
        tv8.text = "intereses Generados: $23750.00"
        tv9.text = "total: $33750.00"
        tv10.text = "banco2: Galicia"
        tv11.text = "intereses Generados2: $5208.75"
        tv12.text = "total2: $15208.75"

        tv13.text = "banco: Galicia"
        tv14.text = "intereses Generados: $5208.75"
        tv14.text = "total: $15208.75"
        tv15.text = "banco2: BBVA"
        tv16.text = "intereses Generados2: $3310.00"
        tv17.text = "total2: $13310.00"

        tv18.text = "banco: Santander"
        tv19.text = "intereses Generados: $23750.00"
        tv20.text = "total: $33750.00"
        tv21.text = "banco2: BBVA"
        tv22.text = "intereses Generados2: $3310.00"
        tv23.text = "total2: $13310.00"

        tv24.text = "banco: BBVA"
        tv25.text = "intereses Generados: $3310.00"
        tv26.text = "total: $13310.00"
        tv27.text = "banco2: Galicia"
        tv28.text = "intereses Generados2: $5208.75"
        tv29.text = "total2: $15208.75"


        bot.setOnClickListener{
            val intent= Intent(this, ingresar::class.java)

            startActivity(intent)
        }



    }
}