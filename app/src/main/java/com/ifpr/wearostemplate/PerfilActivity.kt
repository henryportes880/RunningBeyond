package com.ifpr.wearostemplate

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class PerfilActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_perfil)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}