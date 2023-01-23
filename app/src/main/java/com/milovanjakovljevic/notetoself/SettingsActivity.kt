package com.milovanjakovljevic.notetoself

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.widget.SwitchCompat

class SettingsActivity : AppCompatActivity() {
    private var showDividers:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val prefs = getSharedPreferences("Note to self", MODE_PRIVATE)
        showDividers = prefs.getBoolean("dividers", true)
        var switch1 = findViewById(R.id.switch1) as Switch
        switch1.isChecked = showDividers

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            showDividers = isChecked
        }

    }

    override fun onPause() {
        super.onPause()
        val prefs=getSharedPreferences("Note to self",Context.MODE_PRIVATE)
        val editor=prefs.edit()
        editor.putBoolean("dividers",showDividers)
        editor.apply()
    }
}