package com.ifpr.wearostemplate.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.ifpr.wearostemplate.R

class PerfilActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_perfil)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}