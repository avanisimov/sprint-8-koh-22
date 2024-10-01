package com.example.sprint8koh22

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var lastOnStopTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val isTablet = resources.getBoolean(R.bool.is_tablet)


        val text = findViewById<View>(R.id.text)
        val btn = findViewById<View>(R.id.btn)
        text.setOnClickListener {

        }
        btn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        Log.d("SPRINT_8", "$this onCreate")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("SPRINT_8", "$this onConfigurationChanged")

    }

    override fun onStart() {
        super.onStart()
        Log.d("SPRINT_8", "$this onStart")
        if ((System.currentTimeMillis() - lastOnStopTime) > 10_000) {
            Log.d("SPRINT_8", "$this onStart show PIN code")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("SPRINT_8", "$this onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        Log.d("SPRINT_8", "$this onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SPRINT_8", "$this onStop")
        lastOnStopTime = System.currentTimeMillis()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SPRINT_8", "$this onDestroy")
    }

}