package com.ifpr.wearostemplate.presentation

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.ifpr.wearostemplate.R

class CorridaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_corrida)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}