package com.dam.jonathan.exavaluat4

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
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

        it.setTamaño("Pequeña")
    }
}
    fun MM(view: View) {
        pizza?.let {

            it.setTamaño("Mediana")
        }
    }
    fun MG(view: View) {
        pizza?.let {

            it.setTamaño("Grande")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        pizza = intent.getSerializableExtra("pizza") as? Pizza

        editTextNombre = findViewById(R.id.editTextNombre)

        editTextNombre.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)
            ) {
                // Llama a tu función aquí cuando el usuario presiona "Enter"
                CanviarNom(v.text.toString())
                true
            } else {
                false
            }

        }
        val spinnerTipoMasa: Spinner = findViewById(R.id.spinnerTipoMasa)
        spinnerTipoMasa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Aquí se ejecuta cuando un ítem es seleccionado
                canviarMasa(view)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Método requerido pero que no necesitas usar si no lo deseas
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