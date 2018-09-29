package com.example.zoltantudlik.task2

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var switch: Switch
    private lateinit var portraitTextView: TextView
    private lateinit var landscapeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch = findViewById(R.id.scrChange)
        portraitTextView = findViewById(R.id.textPortrait)
        landscapeTextView = findViewById(R.id.textLandscape)

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            val parentView: View = findViewById(android.R.id.content)
            if(isChecked) {
                rotateView(parentView, parentView.rotation, parentView.rotation + 90)
            } else {
                rotateView(parentView, parentView.rotation, parentView.rotation - 90)
            }
            changeOrientationText(isChecked)
        }

    }

    private fun rotateView(view: View, startDeg: Float, endDeg: Float) {
        view.rotation = startDeg
        view.animate().rotation(endDeg).start()
    }

    private fun changeOrientationText(isChecked: Boolean) {
        if(isChecked) {
            portraitTextView.visibility = View.INVISIBLE
            landscapeTextView.visibility = View.VISIBLE
        } else {
            portraitTextView.visibility = View.VISIBLE
            landscapeTextView.visibility = View.INVISIBLE
        }
    }
}
