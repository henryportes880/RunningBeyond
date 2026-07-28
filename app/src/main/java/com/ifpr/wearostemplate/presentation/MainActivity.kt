package com.ifpr.wearostemplate.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.database.FirebaseDatabase
import com.ifpr.wearostemplate.R
import com.ifpr.wearostemplate.presentation.baseclasses.Corrida
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)
        setContentView(R.layout.activity_main)


        val btnComecar = findViewById<Button>(R.id.btnComecar)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)


        btnComecar.setOnClickListener {

            val intent = Intent(this, CorridaActivity::class.java)
            startActivity(intent)

        }


        btnPerfil.setOnClickListener {

            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)

        }

    }


    private fun salvarCorrida(distanciaKm: Double, tempoSegundos: Long) {

        val referencia = FirebaseDatabase
            .getInstance()
            .getReference("corridas")


        val id = referencia.push().key ?: return


        val dataHora = SimpleDateFormat(
            "dd/MM/yyyy HH:mm",
            Locale.getDefault()
        ).format(Date())


        val corrida = Corrida(
            distanciaKm,
            tempoSegundos,
            calcularRitmo(distanciaKm, tempoSegundos),
            dataHora
        )


        referencia.child(id).setValue(corrida)
    }


    private fun calcularRitmo(
        distanciaKm: Double,
        tempoSegundos: Long
    ): String {

        if (distanciaKm <= 0) return "0:00"


        val segundosPorKm = (tempoSegundos / distanciaKm).toInt()
        val minutos = segundosPorKm / 60
        val segundos = segundosPorKm % 60


        return "$minutos:${segundos.toString().padStart(2, '0')}"
    }
}