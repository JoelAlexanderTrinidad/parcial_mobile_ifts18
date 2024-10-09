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
import android.text.SpannableString
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


         val texv = findViewById<TextView>(R.id.tv1_1)
         val boton = findViewById<Button>(R.id.bot1)
         val ed = findViewById<EditText>(R.id.edit)
         val cb = findViewById<CheckBox>(R.id.check)
         val sp = findViewById<Spinner>(R.id.spi)
         val bot= findViewById<Button>(R.id.tvcb)


        ArrayAdapter.createFromResource(
            this,
            R.array.opcionDeInversion,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp.adapter = adapter
        }


        bot.setOnClickListener{

            val intent3 = Intent(this, tyc::class.java)
            startActivity(intent3)
        }

        boton.setOnClickListener {
            val nombre = ed.text.toString()
            if (nombre.isEmpty()){
                Toast.makeText(this, "ingrese un nombre", Toast.LENGTH_SHORT).show()
            }else{

                val inversionSeleccionada = sp.selectedItem.toString()


                texv.text=" bienvenido $nombre"
                val intent = Intent(this, ingresar::class.java).apply {

                    if(inversionSeleccionada=="plazo fijo"){
                        putExtra("inversion","plazo fijo")
                    }else{putExtra("inversion","fondo comun")}

                    putExtra("nombre",nombre)

                }

                if (cb.isChecked ){


                    if (inversionSeleccionada == "opcion de inversion") {
                        Toast.makeText(this, "seleccione una opcion de inversion", Toast.LENGTH_SHORT).show()
                    } else {
                        startActivity(intent)
                    }

                }else{

                    Toast.makeText(this, "acepte los terminos y condiciones", Toast.LENGTH_SHORT).show()
                }

            }


        }

    }

}










