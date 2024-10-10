package com.dam.jonathan.exavaluat4

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private var pizza: Pizza? = null
    private lateinit var editTextNombre: EditText
    fun IrPagina2(view: View){
        var i = Intent(AActivity@this, MainActivity3::class.java)
        i.putExtra("pizza", pizza)
        startActivity(i)
    }
fun MP(view: View) {
    pizza?.let {

        it.setTamaño("pequeña")
    }
}
    fun MM(view: View) {
        pizza?.let {

            it.setTamaño("mediana")
        }
    }
    fun MG(view: View) {
        pizza?.let {

            it.setTamaño("grande")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        pizza = intent.getSerializableExtra("pizza") as? Pizza
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextNombre.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                Log.i("tgv","uh7")
                if (!editable.isNullOrEmpty()) {
                    pizza?.nombre = editTextNombre.text.toString()
                }
            }
        })
        val spinnerTipoMasa: Spinner = findViewById(R.id.spinnerTipoMasa)
        spinnerTipoMasa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                canviarMasa(view)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.tipos_masa,
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

    private fun canviarMasa(view: View?) {
        pizza?.let {
            val spinnerTipoMasa: Spinner = findViewById(R.id.spinnerTipoMasa)
            val masaSeleccionada = spinnerTipoMasa.selectedItem.toString()
            it.setTipoMasa(masaSeleccionada)
        }
    }
    private fun CanviarNom(text: String) {
        pizza?.let {
            it.setNombre(text)
        }
    }

}