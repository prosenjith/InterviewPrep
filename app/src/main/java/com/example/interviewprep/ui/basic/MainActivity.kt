package com.example.interviewprep.ui.basic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.interviewprep.R
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Lifecycle"
    }

    private val viewModel: MainViewModel by viewModels()

    init {
        Log.e(TAG, "MainActivity initialized")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG, "$localClassName onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
        observeData()
    }

    override fun onRestart() {
        Log.e(TAG, "$localClassName onRestart")
        super.onRestart()
    }

    override fun onStart() {
        Log.e(TAG, "$localClassName onStart")
        Log.e(
            TAG,
            "activity=${this.hashCode()}\nviewModel=${viewModel.hashCode()}\nviewModelStore=${this.viewModelStore.hashCode()}"
        )
        super.onStart()
    }

    override fun onResume() {
        Log.e(TAG, "$localClassName onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e(TAG, "$localClassName onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e(TAG, "$localClassName onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "$localClassName onDestroy")
        super.onDestroy()
    }

    private fun setUpViews() {
        val button = findViewById<MaterialButton>(R.id.button)
        button.text = getString(R.string.navigate_to_secondactivity)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observeData() {

    }
}