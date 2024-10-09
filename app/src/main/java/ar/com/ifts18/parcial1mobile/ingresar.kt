package ar.com.ifts18.parcial1mobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import android.content.SharedPreferences
import java.math.BigInteger



class ingresar: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.ingresar)
        val nombre = intent.getStringExtra("nombre")
        val tv = findViewById<TextView>(R.id.tv1)
        val ed1 = findViewById<EditText>(R.id.ED1)
        val sp1 = findViewById<Spinner>(R.id.spi1)
        val sp2 = findViewById<Spinner>(R.id.spi2)
        val boton = findViewById<Button>(R.id.guardar)
        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val inversion = intent.getStringExtra("inversion")
        val historial = findViewById<Button>(R.id.histo)


        tv.setText("bienvenido $nombre")

        ArrayAdapter.createFromResource(
            this,
            R.array.tiempoDeInversion,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.entidades,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp1.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.entidades,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp2.adapter = adapter
        }

        historial.setOnClickListener {

            val intent = Intent(this, historialDeInversiones::class.java)
            startActivity(intent)
        }

        boton.setOnClickListener {


            val montoInicialTexto = ed1.text.toString()
            val plazoDiastexto = spinner1.selectedItem.toString()
            val bancoSeleccionado = sp1.selectedItem.toString()
            val bancoSeleccionado2 =sp2.selectedItem.toString()


            if(montoInicialTexto.isEmpty()){
                Toast.makeText(this, "falta ingresar un monto inicial", Toast.LENGTH_SHORT).show()
            }else {
                val montoInicial: Double = montoInicialTexto.toDouble()

                if (plazoDiastexto == "tiempo de inversion") {
                    Toast.makeText(this, "falta un plazo de dias", Toast.LENGTH_SHORT).show()

                } else {
                    val plazoDias = plazoDiastexto.toInt()



                    if (bancoSeleccionado == "entidad bancaria" || bancoSeleccionado2 == "entidad bancaria") {
                        Toast.makeText(this, "falta ingresar una o dos entidades bancarias", Toast.LENGTH_SHORT)
                            .show()
                    } else {


                        if (montoInicial < 0) {
                            Toast.makeText(this, "falta un monto inicial", Toast.LENGTH_SHORT)
                                .show()
                        } else {

                            if (inversion == "plazo fijo") {
                                val plazoBanco: Double = when (bancoSeleccionado) {
                                    "Santander" -> 50.0 / 360.0
                                    "BBVA" -> 40.0 / 360.0
                                    "Galicia" -> 30.0 / 360.0
                                    else -> 0.0
                                }
                                val plazoBanco2: Double = when (bancoSeleccionado2) {
                                    "Santander" -> 50.0 / 360.0
                                    "BBVA" -> 40.0 / 360.0
                                    "Galicia" -> 30.0 / 360.0
                                    else -> 0.0
                                }

                                fun calcularMontoTotal(
                                    montoInicial: Double,
                                    cantidadDias: Int,
                                    plazoBanco: Double
                                ): Double {
                                    return montoInicial + (cantidadDias * plazoBanco * montoInicial / 100)
                                }

                                val montoTotal =
                                    calcularMontoTotal(montoInicial, plazoDias, plazoBanco)
                                val montoTotal2 =
                                    calcularMontoTotal(montoInicial, plazoDias, plazoBanco2)

                                val interesesGenerados = montoTotal - montoInicial
                                val interesesGenerados2 = montoTotal2 - montoInicial

                                val roi = (montoTotal - montoInicial) / montoInicial * 100
                                val roi2 = (montoTotal2 - montoInicial) / montoInicial * 100
                                val intent2 = Intent(this, calculo::class.java).apply {
                                    putExtra("inversion", "plazo fijo")
                                    putExtra("roi", roi)
                                    putExtra("roi2", roi2)
                                    putExtra("montoInicial", montoInicial)
                                    putExtra("banco", bancoSeleccionado)
                                    putExtra("banco 2", bancoSeleccionado2)
                                    putExtra("dias", plazoDias)
                                    putExtra("interesesGenerados", interesesGenerados)
                                    putExtra("interesesGenerados 2", interesesGenerados2)
                                    putExtra("montoTotal", montoTotal)
                                    putExtra("montoTotal 2", montoTotal2)
                                    /*val arrayMandar= arrayOf(bancoSeleccionado, bancoSeleccionado2, interesesGenerados.toString(), interesesGenerados2.toString(),montoTotal.toString(),montoTotal2.toString())
                                    putExtra("arrayMandar",arrayMandar)*/

                                }
                                startActivity(intent2)

                                   /*ibamos a agregar las comparaciones en un array y no tuvimos tiempo y dejamos comentado este codigo */
//                                val preferencias = getSharedPreferences("loginPref", Context.MODE_PRIVATE)
//                                val editor = preferencias.edit()
//
//                                editor.putString("banco", bancoSeleccionado)
//                                editor.putString("banco 2", bancoSeleccionado2)
//
//
//                                editor.putString("interesesGenerados", interesesGenerados.toString())
//                                editor.putString("interesesGenerados 2", interesesGenerados2.toString())
//                                editor.putString("montoTotal", montoTotal.toString())
//                                editor.putString("montoTotal 2", montoTotal2.toString())
//
//                                editor.apply()


                            } else {
                                val inversionInicial = 10000.0
                                val tasaRetornoAnual: Double = when (bancoSeleccionado) {
                                    "Santander" -> 0.5
                                    "BBVA" -> 0.10
                                    "Galicia" -> 0.15
                                    else -> 0.0
                                }
                                val tasaRetornoAnual2: Double = when (bancoSeleccionado2) {
                                    "Santander" -> 0.5
                                    "BBVA" -> 0.10
                                    "Galicia" -> 0.15
                                    else -> 0.0
                                }

                                val años = 3


                                fun calcularFondoComun(
                                    inversionInicial: Double,
                                    tasaRetornoAnual: Double,
                                    años: Int
                                ): Double {
                                    return inversionInicial * Math.pow(
                                        1 + tasaRetornoAnual,
                                        años.toDouble()
                                    )
                                }


                                val montoFinal =
                                    calcularFondoComun(inversionInicial, tasaRetornoAnual, años)
                                val montoFinal2 =
                                    calcularFondoComun(inversionInicial, tasaRetornoAnual2, años)

                                val interesesGanados = montoFinal - inversionInicial
                                val interesesGanados2 = montoFinal2 - inversionInicial

                                val intent2 = Intent(this, calculo::class.java).apply {
                                    putExtra("inversion", "fondo comun")
                                    putExtra("montoInicial", montoInicial)
                                    putExtra("banco", bancoSeleccionado)
                                    putExtra("banco 2", bancoSeleccionado2)
                                    putExtra("dias", plazoDias)
                                    putExtra("interesesGenerados", interesesGanados)
                                    putExtra("interesesGenerados 2", interesesGanados2)
                                    putExtra("montoTotal", montoFinal)
                                    putExtra("montoTotal 2", montoFinal2)
                                }
                                startActivity(intent2)



                            }



                        }


                    }
                }


            }


        }
    }
}








