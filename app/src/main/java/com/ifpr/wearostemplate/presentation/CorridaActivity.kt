package com.ifpr.wearostemplate.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ifpr.wearostemplate.R

class CorridaActivity : ComponentActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corrida)

        database = FirebaseDatabase.getInstance().reference

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnIniciar.setOnClickListener {
            val corrida = HashMap<String, Any>()
            corrida["inicio"] = System.currentTimeMillis()
            corrida["status"] = "INICIADA"

            database.child("corridas")
                .push()
                .setValue(corrida)
        }

        // ====================================================
        // O PRINT DO ITEM 2 É DESTA PARTE AQUI DO CÓDIGO:
        // ====================================================
        btnStop.setOnClickListener {
            salvarCorrida()
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }

    // Função que envia a corrida finalizada ao Realtime Database
    private fun salvarCorrida() {
        val corridaFinalizada = HashMap<String, Any>()
        corridaFinalizada["fim"] = System.currentTimeMillis()
        corridaFinalizada["status"] = "FINALIZADA"
        corridaFinalizada["distancia"] = "0.00 km"
        corridaFinalizada["tempo"] = "00:00"

        database.child("corridas")
            .push()
            .setValue(corridaFinalizada)
            .addOnSuccessListener {
                Toast.makeText(this, "Corrida salva com sucesso!", Toast.LENGTH_SHORT).show()
            }
    }
}