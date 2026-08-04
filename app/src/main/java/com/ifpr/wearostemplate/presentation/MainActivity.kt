package com.ifpr.wearostemplate.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.ifpr.wearostemplate.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)
        setContentView(R.layout.activity_main)

        // Mapeamento dos novos IDs
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnRestart = findViewById<Button>(R.id.btnRestart)
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)

        // Evento do botão Play (Abre a tela de corrida)
        btnPlay.setOnClickListener {
            val intent = Intent(this, CorridaActivity::class.java)
            startActivity(intent)
        }

        // Evento do botão Perfil
        btnPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }
    }
}