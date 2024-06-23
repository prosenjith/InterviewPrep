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
import com.example.interviewprep.ui.basic.MainActivity.Companion.TAG
import com.google.android.material.button.MaterialButton

class FragmentA : Fragment(R.layout.fragment_a) {

    private val className = this::class.simpleName

    init {
        Log.e(TAG, "FragmentA initialized")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "$className onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "$className onCreate savedInstanceState = $savedInstanceState")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "$className onCreateView savedInstanceState = $savedInstanceState")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "$className onViewCreated savedInstanceState = $savedInstanceState")
        setupViews(view)
    }

    /*override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e(TAG, "$className onViewStateRestored savedInstanceState = $savedInstanceState")
    }*/

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "$className onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "$className onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "$className onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "$className onStop")
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "$className onSaveInstanceState")
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "$className onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "$className onDestroy")
    }

    private fun setupViews(view: View) {
        val textView = view.findViewById<TextView>(R.id.textView)
        val button = view.findViewById<MaterialButton>(R.id.button)
        textView.text = this::class.simpleName
        button.text = getString(R.string.navigate_to_fragmentb)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_aFragment_to_searchFragment)
        }
    }
}