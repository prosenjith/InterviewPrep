package com.example.interviewprep.ui.basic

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.interviewprep.R
import com.google.android.material.button.MaterialButton

class FragmentB : Fragment(R.layout.fragment_a) {

    private val className = this::class.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(MainActivity.TAG, "$className onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(MainActivity.TAG, "$className onCreate savedInstanceState = $savedInstanceState")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(MainActivity.TAG, "$className onCreateView savedInstanceState = $savedInstanceState")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(MainActivity.TAG, "$className onViewCreated savedInstanceState = $savedInstanceState")
        setupViews(view)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e(
            MainActivity.TAG,
            "$className onViewStateRestored savedInstanceState = $savedInstanceState"
        )
    }

    override fun onStart() {
        super.onStart()
        Log.e(MainActivity.TAG, "$className onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(MainActivity.TAG, "$className onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(MainActivity.TAG, "$className onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(MainActivity.TAG, "$className onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(MainActivity.TAG, "$className onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(MainActivity.TAG, "$className onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(MainActivity.TAG, "$className onDestroy")
    }

    private fun setupViews(view: View) {
        val textView = view.findViewById<TextView>(R.id.textView)
        val button = view.findViewById<MaterialButton>(R.id.button)

        textView.text = this::class.simpleName
        button.text = getString(R.string.navigate_to_fragmenta)
        button.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}