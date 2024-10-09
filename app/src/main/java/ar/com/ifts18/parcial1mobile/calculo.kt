package ar.com.ifts18.parcial1mobile

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class calculo: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.calculo)

        val tv0= findViewById<TextView>(R.id.TV0_1_1)
        var tv1= findViewById<TextView>(R.id.TV1_1_1)
        var tv2= findViewById<TextView>(R.id.TV2_1_1)
        var tv2_2= findViewById<TextView>(R.id.TV2_1_2)
        var tv3= findViewById<TextView>(R.id.TV3_1_1)
        var tv4= findViewById<TextView>(R.id.TV4_1_1)
        var tv4_2= findViewById<TextView>(R.id.TV4_1_2)
        var tv5= findViewById<TextView>(R.id.TV5_1_1)
        var tv5_2= findViewById<TextView>(R.id.TV5_1_2)
        var tv6= findViewById<TextView>(R.id.TV6_1_1)
        var bot1= findViewById<Button>(R.id.atras)
        var bot2= findViewById<Button>(R.id.finalizar)



        val montoInicial = intent.getDoubleExtra("montoInicial", 0.0)
        val banco = intent.getStringExtra("banco") ?: "Desconocido"
        val banco2 = intent.getStringExtra("banco 2") ?: "Desconocido"
        val dias = intent.getIntExtra("dias", 0)
        val interesesGenerados = intent.getDoubleExtra("interesesGenerados", 0.0)
        val interesesGenerados2 = intent.getDoubleExtra("interesesGenerados 2", 0.0)
        val montoTotal = intent.getDoubleExtra("montoTotal", 0.0)
        val montoTotal2 = intent.getDoubleExtra("montoTotal 2", 0.0)
        val roi = intent.getDoubleExtra("roi", 0.0)
        val roi2 = intent.getDoubleExtra("roi2", 0.0)
        val inversion =intent.getStringExtra("inversion")

        if(inversion == "plazo fijo"){
            tv0.text = "tipo de inversion: plazo fijo "
            tv1.text = "monto inicial:                   $$montoInicial"
            tv2.text = "banco:                         $banco"
            tv3.text = "plazo de días:                         $dias"
            tv4.text = String.format("intereses generados: $%.2f",interesesGenerados)
            tv5.text = String.format("monto total:    $%.2f",montoTotal)


            tv2_2.text="banco 2:                         $banco2"
            tv4_2.text = String.format("intereses generados: $%.2f",interesesGenerados2)
            tv5_2.text = String.format("monto total:    $%.2f",montoTotal2)

            if(montoTotal>montoTotal2){
                tv6.setText("sugerencia: el banco $banco genera un mejor resultado a su inversion, con ROI de $roi%")
            }else{tv6.setText("sugerencia: el banco $banco2 genera un mejor resultado a su inversion, con ROI de $roi2%")}

        }
        if(inversion == "fondo comun"){
            tv0.text = "tipo de inversion: fondo comun "
            tv1.text = "monto inicial:                   $$montoInicial"
            tv2.text = "banco:                         $banco"
            tv3.text = "plazo de días:                         $dias"
            tv4.text = String.format("intereses generados: $%.2f",interesesGenerados)
            tv5.text = String.format("monto total:    $%.2f",montoTotal)


            tv2_2.text="banco 2:                         $banco2"
            tv4_2.text = String.format("intereses generados: $%.2f",interesesGenerados2)
            tv5_2.text = String.format("monto total:    $%.2f",montoTotal2)

            if(montoTotal>montoTotal2){
                tv6.setText("sugerencia: el banco $banco genera un mejor resultado a su inversion")
            }else{tv6.setText("sugerencia: el banco $banco2 genera un mejor resultado a su inversion")}

        }

       bot1.setOnClickListener{
           val intent= Intent(this, ingresar::class.java)
           startActivity(intent)
       }

       bot2.setOnClickListener{
           val intent1= Intent(this, MainActivity::class.java)
           startActivity(intent1)
       }










    }

    }
