package com.dam.jonathan.exavaluat4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    private var pizza: Pizza? = null
    fun IrPagina4(view: View){
        var i = Intent(AActivity@this, MainActivity5::class.java)
        i.putExtra("pizza", pizza)
        startActivity(i)
    }
    fun PiñaS(view: View) {
        pizza?.let {

            it.setSetas(true)
        }
    }
    fun PiñaN(view: View) {
        pizza?.let {
            it.setSetas(false)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        pizza = intent.getSerializableExtra("pizza") as? Pizza
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}