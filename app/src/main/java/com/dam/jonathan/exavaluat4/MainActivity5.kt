package com.dam.jonathan.exavaluat4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity() {
    private var pizza: Pizza? = null
    fun IrPagina1(view: View){
        var i = Intent(AActivity@this, MainActivity6::class.java)
        i.putExtra("pizza", pizza)
        startActivity(i)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        pizza = intent.getSerializableExtra("pizza") as? Pizza
        val spinnerTipoMasa: Spinner = findViewById(R.id.spinner)
        spinnerTipoMasa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Vegana") {
                    pizza?.setEsVegana(true)
                    pizza?.setEsVegetariana(false)
                }
                if (selectedItem == "Vegeteriana") {
                    pizza?.setEsVegetariana(true)
                    pizza?.setEsVegana(false)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.tipos_espaciales,
            R.layout.custom_spinner_item

        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinnerTipoMasa.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}