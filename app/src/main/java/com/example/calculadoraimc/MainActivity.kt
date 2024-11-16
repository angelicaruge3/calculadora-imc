//Creado por la estudiante Angelica Ruge Castellanos.

package com.utc.imc

import android.R
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var txtNumero1: EditText? = null
    var txtNumero2: EditText? = null
    var txtNumero3: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtNumero1 = findViewById<EditText>(R.id.txtNumero1)
        txtNumero2 = findViewById<EditText>(R.id.txtNumero2)
        txtNumero3 = findViewById<EditText>(R.id.txtNumero3)
    }

    fun imc(vista: View?) {
        val numero1Texto = txtNumero1!!.text.toString()
        val numero2Texto = txtNumero2!!.text.toString()
        val numero3Texto = txtNumero3!!.text.toString()
        if (numero1Texto == "" || numero2Texto == "" || numero3Texto == "") {
            Toast.makeText(applicationContext, "Por favor llene los datos", Toast.LENGTH_LONG)
                .show()
        } else {
            val numero1 = numero1Texto.toInt()
            val numero2 = numero2Texto.toFloat()
            var numero3 = numero3Texto.toFloat()
            numero3 = numero3 / 100
            //Proceso de calcular el indice de masa corporal
            val imc = numero2 / numero3.pow(2.0) as Float
            //Convirtiendo el resultado a texto
            val imcTexto = String.format("%.1f", imc)
            if (imc < 18.5f) Toast.makeText(
                applicationContext,
                "Su edad es de: $numero1 y su indice de masa coporal es de: $imcTexto usted tiene Desnutricion",
                Toast.LENGTH_LONG
            ).show() // Desnutrición

            if (imc >= 18.5f && imc < 25) Toast.makeText(
                applicationContext,
                "Su edad es de: $numero1 y su indice de masa coporal es de: $imcTexto usted esta Normal",
                Toast.LENGTH_LONG
            ).show() // Normal

            if (imc >= 25 && imc < 30) Toast.makeText(
                applicationContext,
                "Su edad es de: $numero1 y su indice de masa coporal es de: $imcTexto usted tiene Sobrepeso",
                Toast.LENGTH_LONG
            ).show() //Sobrepeso

            if (imc >= 30 && imc < 35) Toast.makeText(
                applicationContext,
                "Su edad es de: $numero1 y su indice de masa coporal es de: $imcTexto usted tiene Obesidad Grado 1",
                Toast.LENGTH_LONG
            ).show() // Obestdad Grado1

            if (imc >= 35 && imc < 40) Toast.makeText(
                applicationContext,
                "Su edad es de: $numero1 y su indice de masa coporal es de: $imcTexto usted tiene Obesidad Grado 2",
                Toast.LENGTH_LONG
            ).show() // Obesidod Grado2

            if (imc >= 40) Toast.makeText(
                applicationContext,
                "Su edad es de: $numero1 y su indice de masa coporal es de: $imcTexto usted tiene Obesidad Grado 3",
                Toast.LENGTH_LONG
            ).show() // Obesidod Grado3
        }
    }
}