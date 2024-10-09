package com.dam.jonathan.exavaluat4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var pizza : Pizza
    fun toggleOpacity(view: View) {
        if (imageView1.alpha == 1.0f) {
            imageView1.alpha = 0.0f
            imageView2.alpha = 1.0f
        } else {
            imageView1.alpha = 1.0f
            imageView2.alpha = 0.0f
        }
        pizza.canviarBase();
    }
    fun IrPagina1(view: View){
        var i = Intent(AActivity@this, MainActivity2::class.java)
        i.putExtra("pizza", pizza)
        startActivity(i)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageView1 = findViewById(R.id.imageView1)
        imageView2 = findViewById(R.id.imageView2)
        imageView1.alpha = 1.0f
        imageView2.alpha = 0.0f
        pizza = Pizza()
    }
}