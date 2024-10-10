package com.dam.jonathan.exavaluat4

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity7 : AppCompatActivity() {
    private var pizza: Pizza? = null
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var NT: TextView
    private lateinit var MT: TextView
    private lateinit var TT: TextView
    private lateinit var PiñaT: TextView
    private lateinit var BoletT: TextView
    private lateinit var VegaT: TextView
    private lateinit var VegeterianaT: TextView
    private lateinit var FET: TextView
    private lateinit var MET: TextView
    private lateinit var PT: TextView
    private lateinit var CT: TextView
    private lateinit var DT: TextView
    private lateinit var PrecioT: TextView
    private lateinit var PrecioToatalT: TextView
    fun suma(view: View) {
        pizza?.let {
            it.setCantidad(it.cantidad + 1)
            updateTextViews()
        }
    }

    fun restar(view: View) {
        pizza?.let {
            if (it.cantidad > 0) {  // Ensure quantity does not go below zero
                it.setCantidad(it.cantidad - 1)
                updateTextViews()
            }
        }
    }

    private fun updateTextViews() {
        CT.text = "Cuantitat : ${pizza?.cantidad}"
        PrecioToatalT.text = "Preu Total : ${pizza?.precioTotal}"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)
        pizza = intent.getSerializableExtra("pizza") as? Pizza
        imageView1 = findViewById(R.id.imageView1)
        imageView2 = findViewById(R.id.imageView2)
        NT = findViewById(R.id.textNom)
        MT = findViewById(R.id.textMasa)
        TT = findViewById(R.id.textT)
        PiñaT = findViewById(R.id.textPiña)
        BoletT = findViewById(R.id.textBolets)
        VegaT = findViewById(R.id.textVegana)
        VegeterianaT = findViewById(R.id.textVegeteriana)
        FET = findViewById(R.id.textFormatgeExtra)
        MET = findViewById(R.id.masaRellena)
        PT = findViewById(R.id.textPicante)
        CT = findViewById(R.id.textCantiat)
        DT = findViewById(R.id.data)

        PrecioT = findViewById(R.id.textPrecio)
        NT.text = "${NT.text}${pizza?.nombre}"
        PrecioT.text = "${PrecioT.text}${pizza?.precio}"
        PrecioToatalT = findViewById(R.id.textPrecioTotal)
        PrecioToatalT.text = "${PrecioToatalT.text}${pizza?.precioTotal}"

        MT.text = "${MT.text}${pizza?.tipoMasa}"
        TT.text = "${TT.text}${pizza?.tamaño}"
        DT.text = "${DT.text}${pizza?.getIniciComanda().toString()}"
        CT.text = "${CT.text} 1"
        PiñaT.text = if (pizza?.isPiña == true) "${PiñaT.text} SI" else "${PiñaT.text} NO"
        BoletT.text = if (pizza?.isSetas == true) "${BoletT.text} SI" else "${BoletT.text} NO"
        VegaT.text = if (pizza?.isEsVegana == true) "${VegaT.text} SI" else "${VegaT.text} NO"
        VegeterianaT.text = if (pizza?.isEsVegetariana == true) "${VegeterianaT.text} SI" else "${VegeterianaT.text} NO"
        FET.text = if (pizza?.isQuezoExtra == true) "${FET.text} SI" else "${FET.text} NO"
        MET.text = if (pizza?.isMasaRellena == true) "${MET.text} SI" else "${MET.text} NO"
        PT.text = if (pizza?.isEsPicante == true) "${PT.text} SI" else "${PT.text} NO"

        if (pizza?.getBase() == 2) {
            imageView1.alpha = 0.0f
            imageView2.alpha = 1.0f
        } else {
            imageView1.alpha = 1.0f
            imageView2.alpha = 0.0f
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}