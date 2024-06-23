package com.example.interviewprep.ui.basic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.interviewprep.R

class SecondActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "Lifecycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.e(TAG, "SecondActivity onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "SecondActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "SecondActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "SecondActivity onResume")
    }

    override fun onPause() {
        Log.e(TAG, "SecondActivity onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e(TAG, "SecondActivity onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "SecondActivity onDestroy")
        super.onDestroy()
    }
}